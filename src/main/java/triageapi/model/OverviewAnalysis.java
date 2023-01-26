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

/**
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class OverviewAnalysis {

    private int score;
    private String[] family;
    private String[] tags;
    private boolean empty;

    public OverviewAnalysis() {
        empty = true;
        score = -1;
        family = new String[0];
        tags = new String[0];
    }

    public OverviewAnalysis(int score, String[] family, String[] tags) {
        empty = false;
        this.score = score;
        this.family = family;
        this.tags = tags;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public boolean isEmpty() {
        return empty;
    }
}
