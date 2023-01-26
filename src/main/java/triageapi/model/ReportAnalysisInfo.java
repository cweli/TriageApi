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
public class ReportAnalysisInfo {

    private int score;
    private String family;
    private List<String> tags;
    private List<String> ttp;
    private List<String> features;
    private String submitted;
    private String reported;
    private int maxTimeNetwork;
    private int maxTimeKernel;
    private String backend;
    private String resource;
    private List<String> resourceTags;
    private String platform;
    private boolean empty;

    public ReportAnalysisInfo() {
        empty = true;
        score = -1;
        family = "";
        tags = new ArrayList<>();
        ttp = new ArrayList<>();
        features = new ArrayList<>();
        submitted = "";
        reported = "";
        maxTimeNetwork = -1;
        maxTimeKernel = -1;
        backend = "";
        resource = "";
        resourceTags = new ArrayList<>();
        platform = "";
    }

    public ReportAnalysisInfo(int score, String family, List<String> tags, List<String> ttp, List<String> features, String submitted, String reported, int maxTimeNetwork, int maxTimeKernel, String backend, String resource, List<String> resourceTags, String platform) {
        empty = false;
        this.score = score;
        this.family = family;
        this.tags = tags;
        this.ttp = ttp;
        this.features = features;
        this.submitted = submitted;
        this.reported = reported;
        this.maxTimeNetwork = maxTimeNetwork;
        this.maxTimeKernel = maxTimeKernel;
        this.backend = backend;
        this.resource = resource;
        this.resourceTags = resourceTags;
        this.platform = platform;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public List<String> getTtp() {
        return ttp;
    }

    public void setTtp(List<String> ttp) {
        this.ttp = ttp;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
    }

    public int getMaxTimeNetwork() {
        return maxTimeNetwork;
    }

    public void setMaxTimeNetwork(int maxTimeNetwork) {
        this.maxTimeNetwork = maxTimeNetwork;
    }

    public int getMaxTimeKernel() {
        return maxTimeKernel;
    }

    public void setMaxTimeKernel(int maxTimeKernel) {
        this.maxTimeKernel = maxTimeKernel;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<String> getResourceTags() {
        return resourceTags;
    }

    public void setResourceTags(List<String> resourceTags) {
        this.resourceTags = resourceTags;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
