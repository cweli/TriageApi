/*
 * Copyright (C) 2020 Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package triageapi.json;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import triageapi.model.Config;
import triageapi.model.Credentials;
import triageapi.model.Dropper;
import triageapi.model.DropperURL;
import triageapi.model.Dump;
import triageapi.model.Extract;
import triageapi.model.Indicator;
import triageapi.model.Key;
import triageapi.model.NetworkDomainRequest;
import triageapi.model.NetworkDomainResponse;
import triageapi.model.NetworkFlow;
import triageapi.model.NetworkReport;
import triageapi.model.NetworkRequest;
import triageapi.model.NetworkWebRequest;
import triageapi.model.NetworkWebResponse;
import triageapi.model.Ransom;
import triageapi.model.ReportAnalysisInfo;
import triageapi.model.ReportTaskFailure;
import triageapi.model.Signature;
import triageapi.model.TargetDesc;

/**
 * This abstract class contains functions that are used by other parsers
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public abstract class GenericParser {

    /**
     * Converts a given JSONArray object into a List of Strings with all values
     *
     * @param input the JSONArray to convert
     * @return the string array with all values
     */
    protected List<String> optStringList(JSONArray input) {
        List<String> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(input.optString(i));
        }
        return output;
    }

    /**
     * Converts a given JSONArray object into a list of strings
     *
     * @param input the JSONArray to convert
     * @return the same values in a list
     */
    public List<String> optListString(JSONArray input) {
        if (input == null) {
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            output.add(input.optString(i));
        }
        return output;
    }

    protected LocalDateTime epochSecondsToLocalDateTime(int epoch) {
        Instant instant;
        if (epoch >= 0) {
            instant = Instant.ofEpochSecond(epoch);
        } else {
            instant = Instant.MIN;
        }
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }

    protected List<Signature> optSignatureList(JSONArray input) {
        List<Signature> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getSignature(input.getJSONObject(i)));
        }
        return output;
    }

    protected Signature getSignature(JSONObject json) {
        if (json == null) {
            return new Signature();
        }
        String label = json.optString("label");
        String name = json.optString("name");
        int score = json.optInt("score");
        List<String> ttp = optStringList(json.optJSONArray("ttp"));
        List<String> tags = optStringList(json.optJSONArray("tags"));
        List<Indicator> indicators = optIndicatorList(json.optJSONArray("indicators"));
        String yaraRule = json.optString("yara_rule");
        String description = json.optString("desc");
        String url = json.optString("url");
        return new Signature(label, name, score, ttp, tags, indicators, yaraRule, description, url);
    }

    protected List<Indicator> optIndicatorList(JSONArray input) {
        List<Indicator> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getIndicator(input.optJSONObject(i)));
        }
        return output;
    }

    protected Indicator getIndicator(JSONObject json) {
        if (json == null) {
            return new Indicator();
        }
        String ioc = json.optString("ioc");
        String description = json.optString("description");
        int at = json.optInt("at");
        int sourcePid = json.optInt("pid");
        int sourceProcId = json.optInt("procid");
        int targetPid = json.optInt("pid_target");
        int targetProcId = json.optInt("procid_target");
        int flow = json.optInt("flow");
        String dumpFile = json.optString("dump_file");
        String resource = json.optString("resource");
        String yaraRule = json.optString("yara_rule");
        return new Indicator(ioc, description, at, sourcePid, sourceProcId, targetPid, targetProcId, flow, dumpFile, resource, yaraRule);
    }

    protected List<Extract> optExtractList(JSONArray input) {
        List<Extract> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getExtract(input.getJSONObject(i)));
        }
        return output;
    }

    protected List<Dump> optDumpList(JSONArray input) {
        List<Dump> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getDump(input.getJSONObject(i)));
        }
        return output;
    }

    protected List<triageapi.model.Process> optProcessList(JSONArray input) {
        List<triageapi.model.Process> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getProcess(input.getJSONObject(i)));
        }
        return output;
    }

    protected List<ReportTaskFailure> optReportTaskFailureList(JSONArray input) {
        List<ReportTaskFailure> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getReportTaskFailure(input.getJSONObject(i)));
        }
        return output;
    }

    protected List<DropperURL> optDropperUrlList(JSONArray input) {
        List<DropperURL> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getDropperURL(input.optJSONObject(i)));
        }
        return output;
    }

    protected List<Key> optKeyList(JSONArray input) {
        List<Key> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getKey(input.optJSONObject(i)));
        }
        return output;
    }

    protected byte[][] optByteArrayArray(JSONArray input) {
        if (input == null) {
            return new byte[0][0];
        }
        byte[][] output = new byte[0][input.length()];
        for (int i = 0; i < output.length; i++) {
            //output[i] = getKey(input.optJSONObject(i));
        }
        return output;
    }

    protected NetworkFlow[] optNetworkFlowArray(JSONArray input) {
        if (input == null) {
            return new NetworkFlow[0];
        }
        NetworkFlow[] output = new NetworkFlow[input.length()];
        for (int i = 0; i < output.length; i++) {
            output[i] = getNetworkFlow(input.optJSONObject(i));
        }
        return output;
    }

    protected NetworkRequest[] optNetworkRequestArray(JSONArray input) {
        if (input == null) {
            return new NetworkRequest[0];
        }
        NetworkRequest[] output = new NetworkRequest[input.length()];
        for (int i = 0; i < output.length; i++) {
            output[i] = getNetworkRequest(input.optJSONObject(i));
        }
        return output;
    }

    protected TargetDesc getTargetDesc(JSONObject json) {
        if (json == null) {
            return new TargetDesc();
        }
        String id = json.optString("id");
        int score = json.optInt("score");
        String submitted = json.optString("submitted");
        String compatCompleted = json.optString("completed");
        String target = json.optString("target");
        String pick = json.optString("pick");
        String type = json.optString("type");
        int size = json.optInt("size");
        String md5 = json.optString("md5");
        String sha1 = json.optString("sha1");
        String sha256 = json.optString("sha256");
        String sha512 = json.optString("sha512");
        String ssdeep = json.optString("ssdeep");
        String fileType = json.optString("filetype");
        //static_tags
        List<String> staticTags = optStringList(json.optJSONArray("static_tags"));
        String compatFamily = json.optString("family");

        return new TargetDesc(id, score, submitted, compatCompleted, target, pick, type, size, md5, sha1, sha256, sha512, ssdeep, fileType, staticTags, compatFamily);
    }

    protected ReportTaskFailure getReportTaskFailure(JSONObject json) {
        if (json == null) {
            return new ReportTaskFailure();
        }

        String task = json.optString("task");
        String backend = json.optString("backend");
        String reason = json.optString("reason");
        return new ReportTaskFailure(task, backend, reason);
    }

    protected ReportAnalysisInfo getReportAnalysisInfo(JSONObject json) {
        if (json == null) {
            return new ReportAnalysisInfo();
        }
        int score = json.optInt("score");
        String family = json.optString("family");
        List<String> tags = optStringList(json.getJSONArray("tags"));
        List<String> ttp = optStringList(json.optJSONArray("ttp"));
        List<String> features = optStringList(json.optJSONArray("features"));
        String submitted = json.optString("submitted");
        String reported = json.optString("reported");
        int maxTimeNetwork = json.optInt("max_time_network");
        int maxTimeKernel = json.optInt("max_time_kernel");
        String backend = json.optString("backend");
        String resource = json.optString("resource");
        List<String> resourceTags = optStringList(json.optJSONArray("resource_tags"));
        String platform = json.optString("platform");
        return new ReportAnalysisInfo(score, family, tags, ttp, features, submitted, reported, maxTimeNetwork, maxTimeKernel, backend, resource, resourceTags, platform);
    }

    protected triageapi.model.Process getProcess(JSONObject json) {
        if (json == null) {
            return new triageapi.model.Process();
        }
        int procId = json.optInt("procid");
        int parentProcId = json.optInt("procid_parent");
        int pid = json.optInt("pid");
        int ppid = json.optInt("ppid");
        //TODO string on windows, List<String> on linux: fix
        String cmd = json.optString("cmd");
        String image = json.optString("image");
        boolean orig = json.optBoolean("orig");
        boolean system = json.optBoolean("-");
        int started = json.optInt("started");
        int terminated = json.optInt("terminated");
        return new triageapi.model.Process(procId, parentProcId, pid, ppid, cmd, image, orig, system, started, terminated);
    }

    protected NetworkReport getNetworkReport(JSONObject json) {
        if (json == null) {
            return new NetworkReport();
        }

        NetworkFlow[] flows = optNetworkFlowArray(json.optJSONArray("flows"));
        NetworkRequest[] requests = optNetworkRequestArray(json.optJSONArray("requests"));
        return new NetworkReport(flows, requests);
    }

    protected Dump getDump(JSONObject json) {
        if (json == null) {
            return new Dump();
        }

        int at = json.optInt("at");
        int pid = json.optInt("pid");
        int procId = json.optInt("procid");
        String path = json.optString("path");
        String name = json.optString("name");
        String kind = json.optString("kind");
        int addr = json.optInt("addr");
        int length = json.optInt("length");
        return new Dump(at, pid, procId, path, name, kind, addr, length);
    }

    protected Extract getExtract(JSONObject json) {
        if (json == null) {
            return new Extract();
        }

        String dumpedFile = json.optString("dumped_file");
        String resource = json.optString("resource");
        Config config = getConfig(json.optJSONObject("config"));
        String path = json.optString("path");
        Ransom ransom = getRansom(json.optJSONObject("ransom_note"));
        Dropper dropper = getDropper(json.optJSONObject("dropper"));
        Credentials credentials = getCredentials(json.optJSONObject("credentials"));
        return new Extract(dumpedFile, resource, config, path, ransom, dropper, credentials);
    }

    protected NetworkFlow getNetworkFlow(JSONObject json) {
        if (json == null) {
            return new NetworkFlow();
        }
        int id = json.optInt("id");
        String source = json.optString("src");
        String dest = json.optString("dst");
        String proto = json.optString("proto");
        int pid = json.optInt("pid");
        int procId = json.optInt("procid");
        int firstSeen = json.optInt("first_seen");
        int lastSeen = json.optInt("last_seen");
        int rxBytes = json.optInt("rx_bytes");
        int rxPackets = json.optInt("rx_packets");
        int txBytes = json.optInt("tx_bytes");
        int txPackets = json.optInt("tx_packets");
        String domain = json.optString("domain");
        String ja3 = json.optString("tls_ja3");
        String sni = json.optString("sni");
        String country = json.optString("country");
        String as = json.optString("as_num");
        String org = json.optString("as_org");
        return new NetworkFlow(id, source, dest, proto, pid, procId, firstSeen, lastSeen, rxBytes, rxPackets, txBytes, txPackets, domain, ja3, sni, country, as, org);
    }

    protected NetworkRequest getNetworkRequest(JSONObject json) {
        if (json == null) {
            return new NetworkRequest();
        }
        int flow = json.optInt("flow");
        int at = json.optInt("at");
        NetworkDomainRequest domainReq = getNetworkDomainRequest(json.optJSONObject("dns_request"));
        NetworkDomainResponse domainResp = getNetworkDomainResponse(json.optJSONObject("dns_response"));
        NetworkWebRequest webReq = getNetworkWebRequest(json.optJSONObject("http_request"));
        NetworkWebResponse webResp = getNetworkWebResponse(json.optJSONObject("http_response"));
        return new NetworkRequest(flow, at, domainReq, domainResp, webReq, webResp);
    }

    protected Config getConfig(JSONObject json) {
        if (json == null) {
            return new Config();
        }
        String family = json.optString("family");
        List<String> tags = optStringList(json.optJSONArray("tags"));
        String rule = json.optString("rule");
        List<String> c2 = optStringList(json.optJSONArray("c2"));
        List<String> decoy = optStringList(json.optJSONArray("decoy"));
        String version = json.optString("version");
        String botnet = json.optString("botnet");
        String campaign = json.optString("campaign");
        List<String> mutex = optStringList(json.optJSONArray("mutex"));
        List<String> wallet = optStringList(json.optJSONArray("wallet"));
        List<String> dns = optStringList(json.optJSONArray("dns"));
        List<Key> keys = optKeyList(json.optJSONArray("keys"));
        List<String> webInject = optStringList(json.optJSONArray("webinject"));
        List<String> commandLines = optStringList(json.optJSONArray("command_lines"));
        String listenAddr = json.optString("listen_addr");
        int listenPort = json.optInt("listen_port");
        List<String> listenFor = optStringList(json.optJSONArray("listen_for"));
        byte[][] shellcode = optByteArrayArray(json.optJSONArray("shellcode"));
        List<Credentials> credentials = optCredentialsArray(json.optJSONArray("credentials"));
        List<String> extractedPe = optStringList(json.optJSONArray("extracted_pe"));
        Map<String, String> attributes = optMapStringString(json.optJSONObject("attr"));
        String raw = json.optString("raw");
        return new Config(family, tags, rule, c2, decoy, version, botnet, campaign, mutex, wallet, dns, keys, webInject, commandLines, listenAddr, listenPort, listenFor, shellcode, extractedPe, credentials, attributes, raw);
    }

    protected Map<String, String> optMapStringString(JSONObject json) {
        Map<String, String> mapping = new HashMap<>();
        if (json == null) {
            return mapping;
        }

        for (String key : json.keySet()) {
            String value = json.optString(key);
            mapping.put(key, value);
        }

        return mapping;
    }

    protected Ransom getRansom(JSONObject json) {
        if (json == null) {
            return new Ransom();
        }
        String family = json.optString("family");
        String target = json.optString("target");
        List<String> emails = optStringList(json.optJSONArray("emails"));
        List<String> wallets = optStringList(json.optJSONArray("wallets"));
        List<String> urls = optStringList(json.optJSONArray("urls"));
        List<String> contact = optStringList(json.optJSONArray("contact"));
        String note = json.optString("note");
        return new Ransom(family, target, emails, wallets, urls, contact, note);

    }

    protected Dropper getDropper(JSONObject json) {
        if (json == null) {
            return new Dropper();
        }
        String family = json.optString("family");
        String language = json.optString("language");
        String source = json.optString("source");
        String deobfuscated = json.optString("deobfuscated");
        List<DropperURL> urls = new ArrayList<>();

        JSONArray array = json.optJSONArray("urls");
        if (array != null) {
            urls = optDropperUrlList(json.optJSONArray("urls"));
        }
        return new Dropper(family, language, source, deobfuscated, urls);
    }

    protected NetworkDomainRequest getNetworkDomainRequest(JSONObject json) {
        if (json == null) {
            return new NetworkDomainRequest();
        }
        List<String> domains = optStringList(json.optJSONArray("domains"));
        return new NetworkDomainRequest(domains);
    }

    protected NetworkDomainResponse getNetworkDomainResponse(JSONObject json) {
        if (json == null) {
            return new NetworkDomainResponse();
        }
        List<String> domains = optStringList(json.optJSONArray("domains"));
        List<String> ip = optStringList(json.optJSONArray("ip"));
        return new NetworkDomainResponse(domains, ip);
    }

    protected NetworkWebRequest getNetworkWebRequest(JSONObject json) {
        if (json == null) {
            return new NetworkWebRequest();
        }
        String method = json.optString("method");
        String url = json.optString("url");
        List<String> headers = optStringList(json.optJSONArray("headers"));
        return new NetworkWebRequest(method, url, headers);
    }

    protected NetworkWebResponse getNetworkWebResponse(JSONObject json) {
        if (json == null) {
            return new NetworkWebResponse();
        }
        String status = json.optString("status");
        List<String> headers = optStringList(json.optJSONArray("headers"));
        return new NetworkWebResponse(status, headers);
    }

    protected Key getKey(JSONObject json) {
        if (json == null) {
            return new Key();
        }
        String kind = json.optString("kind");
        String key = json.optString("key");
        String value = json.optString("value");
        return new Key(kind, key, value);
    }

    protected DropperURL getDropperURL(JSONObject json) {
        if (json == null) {
            return new DropperURL();
        }
        String type = json.optString("type");
        String url = json.optString("url");
        return new DropperURL(type, url);
    }

    protected Credentials getCredentials(JSONObject json) {
        if (json == null) {
            return new Credentials();
        }

        int flow = json.optInt("flow");
        String protocol = json.optString("protocol");
        String host = json.optString("host");
        int port = json.optInt("port");
        String username = json.optString("username");
        String password = json.optString("password");
        String emailTo = json.optString("email_to");

        return new Credentials(flow, protocol, host, port, username, password, emailTo);
    }

    protected List<Credentials> optCredentialsArray(JSONArray input) {
        List<Credentials> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getCredentials(input.optJSONObject(i)));
        }
        return output;
    }
}
