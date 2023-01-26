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
import java.util.List;

/**
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class TriageReport {

    private String version;
    private String taskId;
    private TargetDesc sample;
    private TargetDesc task;
    private List<ReportTaskFailure> errors;
    private ReportAnalysisInfo analysis;
    private List<Process> processes;
    private List<Signature> signatures;
    private NetworkReport networkReport;
    private List<Dump> dumped;
    private List<Extract> extracted;
    private boolean isEmpty;

    public TriageReport() {
        this.version = "";
        this.taskId = "";
        this.sample = new TargetDesc();
        this.task = new TargetDesc();
        this.errors = new ArrayList<>();
        this.analysis = new ReportAnalysisInfo();
        this.processes = new ArrayList<>();
        this.signatures = new ArrayList<>();
        this.networkReport = new NetworkReport();
        this.dumped = new ArrayList<>();
        this.extracted = new ArrayList<>();
        this.isEmpty = true;
    }

    public TriageReport(String version, String taskId, TargetDesc sample, TargetDesc task, List<ReportTaskFailure> errors, ReportAnalysisInfo analysis, List<Process> processes, List<Signature> signatures, NetworkReport networkReport, List<Dump> dumped, List<Extract> extracted) {
        this.version = version;
        this.taskId = taskId;
        this.sample = sample;
        this.task = task;
        this.errors = errors;
        this.analysis = analysis;
        this.processes = processes;
        this.signatures = signatures;
        this.networkReport = networkReport;
        this.dumped = dumped;
        this.extracted = extracted;
        this.isEmpty = false;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskid) {
        this.taskId = taskId;
    }

    public TargetDesc getSample() {
        return sample;
    }

    public void setSample(TargetDesc sample) {
        this.sample = sample;
    }

    public TargetDesc getTask() {
        return task;
    }

    public void setTask(TargetDesc task) {
        this.task = task;
    }

    public List<ReportTaskFailure> getErrors() {
        return errors;
    }

    public void setErrors(List<ReportTaskFailure> errors) {
        this.errors = errors;
    }

    public ReportAnalysisInfo getAnalysis() {
        return analysis;
    }

    public void setAnalysis(ReportAnalysisInfo analysis) {
        this.analysis = analysis;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public NetworkReport getNetworkReport() {
        return networkReport;
    }

    public void setNetworkReport(NetworkReport networkReport) {
        this.networkReport = networkReport;
    }

    public List<Dump> getDumped() {
        return dumped;
    }

    public void setDumped(List<Dump> dumped) {
        this.dumped = dumped;
    }

    public List<Extract> getExtracted() {
        return extracted;
    }

    public void setExtracted(List<Extract> extracted) {
        this.extracted = extracted;
    }

}
