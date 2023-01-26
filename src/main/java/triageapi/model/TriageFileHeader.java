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
public class TriageFileHeader {

    private int entryPoint;
    private int magicNumber;
    private List<String> dllCharacteristics;
    private List<String> fileCharacteristics;
    private boolean empty;

    public TriageFileHeader() {
        entryPoint = -1;
        magicNumber = -1;
        dllCharacteristics = new ArrayList<>();
        fileCharacteristics = new ArrayList<>();
        empty = true;
    }

    public TriageFileHeader(int entryPoint, int magicNumber, List<String> dllCharacteristics, List<String> fileCharacteristics) {
        this.entryPoint = entryPoint;
        this.magicNumber = magicNumber;
        this.dllCharacteristics = dllCharacteristics;
        this.fileCharacteristics = fileCharacteristics;
        empty = false;
    }

    public int getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(int entryPoint) {
        this.entryPoint = entryPoint;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public List<String> getDllCharacteristics() {
        return dllCharacteristics;
    }

    public void setDllCharacteristics(List<String> dllCharacteristics) {
        this.dllCharacteristics = dllCharacteristics;
    }

    public List<String> getFileCharacteristics() {
        return fileCharacteristics;
    }

    public void setFileCharacteristics(List<String> fileCharacteristics) {
        this.fileCharacteristics = fileCharacteristics;
    }

    public boolean isEmpty() {
        return empty;
    }
}
