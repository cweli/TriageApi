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
import java.util.List;

/**
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class OverviewExtracted extends Extract {

    private List<String> tasks;
    private boolean empty;

    public OverviewExtracted() {
        super();
        tasks = new ArrayList<>();
        empty = true;
    }

    public OverviewExtracted(Extract extract, List<String> tasks) {
        super(extract.getDumpedFile(), extract.getResource(), extract.getConfig(), extract.getPath(), extract.getRansomNote(), extract.getDropper(), extract.getCredentials());
        this.tasks = tasks;
        empty = false;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public boolean isEmpty() {
        return empty;
    }
}
