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
public class Ransom {

    private String family;
    private String target;
    private List<String> emails;
    private List<String> wallets;
    private List<String> urls;
    private List<String> contact;
    private String note;
    private boolean empty;

    public Ransom() {
        empty = true;
        family = "";
        target = "";
        emails = new ArrayList<>();
        wallets = new ArrayList<>();
        urls = new ArrayList<>();
        contact = new ArrayList<>();
        note = "";
    }

    public Ransom(String family, String target, List<String> emails, List<String> wallets, List<String> urls, List<String> contact, String note) {
        empty = false;
        this.family = family;
        this.target = target;
        this.emails = emails;
        this.wallets = wallets;
        this.urls = urls;
        this.contact = contact;
        this.note = note;
    }

    public boolean isEmpty() {
        return empty || (emails.isEmpty() && wallets.isEmpty() && urls.isEmpty() && contact.isEmpty() && note.isEmpty() && family.isEmpty() && target.isEmpty());
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getWallets() {
        return wallets;
    }

    public void setWallets(List<String> wallets) {
        this.wallets = wallets;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
    
    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
