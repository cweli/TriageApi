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
public class Signature {

    private String label;
    private String name;
    private int score;
    private List<String> ttp;
    private List<String> tags;
    private List<Indicator> indicators;
    private String yaraRule;
    private String description;
    private String url;
    private boolean empty;

    public Signature() {
        empty = true;
        label = "";
        name = "";
        score = -1;
        ttp = new ArrayList<>();
        tags = new ArrayList<>();
        indicators = new ArrayList<>();
        yaraRule = "";
        description = "";
        url = "";
    }

    public Signature(String label, String name, int score, List<String> ttp, List<String> tags, List<Indicator> indicators, String yaraRule, String description, String url) {
        empty = false;
        this.label = label;
        this.name = name;
        this.score = score;
        this.ttp = ttp;
        this.tags = tags;
        this.indicators = indicators;
        this.yaraRule = yaraRule;
        this.description = description;
        this.url = url;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getTtp() {
        return ttp;
    }

    public void setTtp(List<String> ttp) {
        this.ttp = ttp;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    public String getYaraRule() {
        return yaraRule;
    }

    public void setYaraRule(String yaraRule) {
        this.yaraRule = yaraRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
