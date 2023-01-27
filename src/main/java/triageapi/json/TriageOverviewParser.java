/*
 * Copyright (C) 2022 Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import triageapi.model.Credentials;
import triageapi.model.Extract;
import triageapi.model.OverviewAnalysis;
import triageapi.model.OverviewExtracted;
import triageapi.model.OverviewIOCs;
import triageapi.model.OverviewSample;
import triageapi.model.OverviewTarget;
import triageapi.model.ReportTaskFailure;
import triageapi.model.Signature;
import triageapi.model.TargetDesc;
import triageapi.model.TaskSummary;
import triageapi.model.TriageOverview;

/**
 * This parser is used to parse JSON, in the form of a string, into a Triage
 * Overview object
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class TriageOverviewParser extends GenericParser {

    /**
     * Converts the given JSON value in string form into an object. Missing
     * values are set to empty values (or false for booleans) but never null. As
     * such, every field in the returned field can be accessed safely. Each
     * object contains a boolean that is called <code>empty</em>, which is set
     * to true if an object is completely empty.
     *
     * @param rawJson the JSON value to parse
     * @return the object based on the given JSON value
     */
    public TriageOverview parse(String rawJson) {
        if (rawJson == null) {
            return new TriageOverview();
        }
        JSONObject json = new JSONObject(rawJson);

        String version = json.optString("version");
        OverviewSample sample = getOverviewSample(json.optJSONObject("sample"));
        Map<String, TaskSummary> tasks = optTaskSummaryList(json.optJSONObject("tasks"));
        OverviewAnalysis analysis = getOverviewAnalysis(json.optJSONObject("analysis"));
        List<OverviewTarget> targets = optOverviewTargetList(json.optJSONArray("targets"));
        List<ReportTaskFailure> errors = optReportTaskFailureList(json.optJSONArray("errors"));
        List<Signature> signatures = optSignatureList(json.optJSONArray("signatures"));
        List<OverviewExtracted> extracted = optOverviewExtractedList(json.optJSONArray("extracted"));

        return new TriageOverview(version, sample, tasks, analysis, targets, errors, signatures, extracted);
    }

    protected List<OverviewExtracted> optOverviewExtractedList(JSONArray input) {
        List<OverviewExtracted> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getOverviewExtracted(input.optJSONObject(i)));
        }
        return output;
    }

    protected OverviewExtracted getOverviewExtracted(JSONObject json) {
        if (json == null) {
            return new OverviewExtracted();
        }

        Extract extract = getExtract(json);
        List<String> tasks = optStringList(json.optJSONArray("tasks"));

        return new OverviewExtracted(extract, tasks);
    }

    protected List<OverviewTarget> optOverviewTargetList(JSONArray input) {
        List<OverviewTarget> output = new ArrayList<>();
        if (input == null) {
            return output;
        }
        for (int i = 0; i < input.length(); i++) {
            output.add(getOverviewTarget(input.optJSONObject(i)));
        }
        return output;
    }

    protected OverviewTarget getOverviewTarget(JSONObject json) {
        if (json == null) {
            return new OverviewTarget();
        }

        TargetDesc targetDesc = getTargetDesc(json);
        List<String> tasks = optStringList(json.optJSONArray("tasks"));
        List<String> tags = optStringList(json.optJSONArray("tags"));
        List<String> families = optStringList(json.optJSONArray("family"));
        List<Signature> signatures = optSignatureList(json.optJSONArray("signatures"));
        OverviewIOCs overviewIOCs = getOverviewIOCs(json.optJSONObject("iocs"));

        return new OverviewTarget(targetDesc, tasks, tags, families, signatures, overviewIOCs);
    }

    protected OverviewAnalysis getOverviewAnalysis(JSONObject json) {
        if (json == null) {
            return new OverviewAnalysis();
        }

        int score = json.optInt("score");
        List<String> families = optStringList(json.optJSONArray("family"));
        List<String> tags = optStringList(json.optJSONArray("tags"));

        return new OverviewAnalysis(score, families, tags);
    }

    protected Map<String, TaskSummary> optTaskSummaryList(JSONObject input) {
        Map<String, TaskSummary> output = new HashMap<>();
        if (input == null) {
            return output;
        }
        Set<String> keySet = input.keySet();

        for (String key : keySet) {
            JSONObject x = input.optJSONObject(key);
            output.put(key, getTaskSummary(x));
        }

        return output;
    }

    protected TaskSummary getTaskSummary(JSONObject json) {
        if (json == null) {
            return new TaskSummary();
        }

        String sample = json.optString("sample");
        String kind = json.optString("kind");
        String name = json.optString("name");
        String status = json.optString("status");
        List<String> ttps = optStringList(json.optJSONArray("ttp"));
        List<String> tags = optStringList(json.optJSONArray("tags"));
        int score = json.optInt("score");
        String target = json.optString("target");
        String backend = json.optString("backend");
        String resource = json.optString("resource");
        String platform = json.optString("platform");
        String taskName = json.optString("task_name");
        String failure = json.optString("failure");
        int queueId = json.optInt("queue_id");
        String pick = json.optString("pick");
        int sigs = json.optInt("sigs");
        int timeout = json.optInt("timeout");

        return new TaskSummary(sample, kind, name, status, ttps, tags, score, target, backend, resource, platform, taskName, failure, queueId, pick, sigs, timeout);
    }

    protected OverviewSample getOverviewSample(JSONObject json) {
        if (json == null) {
            return new OverviewSample();
        }

        TargetDesc targetDesc = getTargetDesc(json);
        String created = json.optString("created");
        String completed = json.optString("completed");
        OverviewIOCs overviewIOCs = getOverviewIOCs(json.optJSONObject("iocs"));

        return new OverviewSample(targetDesc, created, completed, overviewIOCs);
    }

    protected OverviewIOCs getOverviewIOCs(JSONObject json) {
        if (json == null) {
            return new OverviewIOCs();
        }

        List<String> urls = optStringList(json.optJSONArray("urls"));
        List<String> domains = optStringList(json.optJSONArray("domains"));
        List<String> ips = optStringList(json.optJSONArray("ips"));

        return new OverviewIOCs(urls, domains, ips);
    }

    //Leftover
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
