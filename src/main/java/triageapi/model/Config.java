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
package triageapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class Config {

    private String family;
    private List<String> tags;
    private String rule;
    private List<String> c2;
    private List<String> decoy;
    private String version;
    private String botnet;
    private String campaign;
    private List<String> mutex;
    private List<String> wallet;
    private List<String> dns;
    private List<Key> keys;
    private List<String> webInject;
    private List<String> commandLines;
    private String listenAddr;
    private int listenPort;
    private List<String> listenFor;
    private byte[][] shellcode;
    private List<String> extractedPe;
    private List<Credentials> credentials;
    private Map<String, String> attributes;
    private String raw;
    private boolean empty;

    public Config() {
        empty = true;
        family = "";
        tags = new ArrayList<>();
        rule = "";
        c2 = new ArrayList<>();
        decoy = new ArrayList<>();
        version = "";
        botnet = "";
        campaign = "";
        mutex = new ArrayList<>();
        dns = new ArrayList<>();
        wallet = new ArrayList<>();
        keys = new ArrayList<>();
        webInject = new ArrayList<>();
        commandLines = new ArrayList<>();
        listenAddr = "";
        listenPort = -1;
        listenFor = new ArrayList<>();
        shellcode = new byte[0][0];
        extractedPe = new ArrayList<>();
        credentials = new ArrayList<>();
        attributes = new HashMap<>();
        raw = "";
    }

    public Config(String family, List<String> tags, String rule, List<String> c2, List<String> decoy, String version, String botnet, String campaign, List<String> mutex, List<String> wallet, List<String> dns, List<Key> keys, List<String> webInject, List<String> commandLines, String listenAddr, int listenPort, List<String> listenFor, byte[][] shellcode, List<String> extractedPe, List<Credentials> credentials, Map<String, String> attributes, String raw) {
        empty = false;
        this.family = family;
        this.tags = tags;
        this.rule = rule;
        this.c2 = c2;
        this.decoy = decoy;
        this.version = version;
        this.botnet = botnet;
        this.campaign = campaign;
        this.mutex = mutex;
        this.wallet = wallet;
        this.dns = dns;
        this.keys = keys;
        this.webInject = webInject;
        this.commandLines = commandLines;
        this.listenAddr = listenAddr;
        this.listenPort = listenPort;
        this.listenFor = listenFor;
        this.shellcode = shellcode;
        this.extractedPe = extractedPe;
        this.credentials = credentials;
        this.attributes = attributes;
        this.raw = raw;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public List<String> getC2() {
        return c2;
    }

    public void setC2(List<String> c2) {
        this.c2 = c2;
    }

    public List<String> getDecoy() {
        return decoy;
    }

    public void setDecoy(List<String> decoy) {
        this.decoy = decoy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBotnet() {
        return botnet;
    }

    public void setBotnet(String botnet) {
        this.botnet = botnet;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public List<String> getMutex() {
        return mutex;
    }

    public void setMutex(List<String> mutex) {
        this.mutex = mutex;
    }

    public List<String> getDns() {
        return dns;
    }

    public void setDns(List<String> dns) {
        this.dns = dns;
    }

    public List<String> getWallet() {
        return wallet;
    }

    public void setWallet(List<String> wallet) {
        this.wallet = wallet;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public List<String> getWebInject() {
        return webInject;
    }

    public void setWebInject(List<String> webInject) {
        this.webInject = webInject;
    }

    public List<String> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<String> commandLines) {
        this.commandLines = commandLines;
    }

    public String getListenAddr() {
        return listenAddr;
    }

    public void setListenAddr(String listenAddr) {
        this.listenAddr = listenAddr;
    }

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public List<String> getListenFor() {
        return listenFor;
    }

    public void setListenFor(List<String> listenFor) {
        this.listenFor = listenFor;
    }

    public byte[][] getShellcode() {
        return shellcode;
    }

    public void setShellcode(byte[][] shellcode) {
        this.shellcode = shellcode;
    }

    public List<String> getExtractedPe() {
        return extractedPe;
    }

    public void setExtractedPe(List<String> extractedPe) {
        this.extractedPe = extractedPe;
    }

    public List<Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getRaw() {return raw;}
    public void setRaw(String raw) { this.raw = raw;}

}
