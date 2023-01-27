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
package triageapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An overview of the given submission, including information from all reports
 * (both dynamic and static)
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class TriageOverview {

    private String version;
    private OverviewSample sample;
    private Map<String, TaskSummary> tasks;
    private OverviewAnalysis analysis;
    private List<OverviewTarget> targets;
    private List<ReportTaskFailure> errors;
    private List<Signature> signatures;
    private List<OverviewExtracted> extracted;
    private boolean empty;

    public TriageOverview() {
        empty = true;
        this.version = "";
        this.sample = new OverviewSample();
        this.tasks = new HashMap<>();
        this.analysis = new OverviewAnalysis();
        this.targets = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.signatures = new ArrayList<>();
        this.extracted = new ArrayList<>();
    }

    public TriageOverview(String version, OverviewSample sample, Map<String, TaskSummary> tasks, OverviewAnalysis analysis, List<OverviewTarget> targets, List<ReportTaskFailure> errors, List<Signature> signatures, List<OverviewExtracted> extracted) {
        empty = false;
        this.version = version;
        this.sample = sample;
        this.tasks = tasks;
        this.analysis = analysis;
        this.targets = targets;
        this.errors = errors;
        this.signatures = signatures;
        this.extracted = extracted;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public OverviewSample getSample() {
        return sample;
    }

    public void setSample(OverviewSample sample) {
        this.sample = sample;
    }

    public Map<String, TaskSummary> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, TaskSummary> tasks) {
        this.tasks = tasks;
    }

    public OverviewAnalysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(OverviewAnalysis analysis) {
        this.analysis = analysis;
    }

    public List<OverviewTarget> getTargets() {
        return targets;
    }

    public void setTargets(List<OverviewTarget> targets) {
        this.targets = targets;
    }

    public List<ReportTaskFailure> getErrors() {
        return errors;
    }

    public void setErrors(List<ReportTaskFailure> errors) {
        this.errors = errors;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<OverviewExtracted> getExtracted() {
        return extracted;
    }

    public void setExtracted(List<OverviewExtracted> extracted) {
        this.extracted = extracted;
    }

    public boolean isEmpty() {
        return empty;
    }
}
