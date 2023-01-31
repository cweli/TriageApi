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

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Max 'Libra' Kersten [@Libranalysis, https://maxkersten.nl]
 */
public class Credentials {

    private int flow;
    private String protocol;
    private String host;
    @SerializedName("email_to")
    private String emailTo;
    private int port;
    private String username;
    private String password;
    private boolean empty;

    public Credentials() {
        flow = -1;
        protocol = "";
        host = "";
        port = -1;
        username = "";
        password = "";
        empty = true;
        emailTo = "";
    }

    public Credentials(int flow, String protocol, String host, int port, String username, String password, String emailTo) {
        this.flow = flow;
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.empty = false;
        this.emailTo = emailTo;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailTo() { return emailTo; }

    public void setEmailTo(String emailTo) { this.emailTo = emailTo; }

    public boolean isEmpty() {
        return empty || (protocol.isEmpty() && host.isEmpty() && username.isEmpty() && password.isEmpty() && emailTo.isEmpty());
    }
}
