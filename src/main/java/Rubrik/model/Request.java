package Rubrik.model;

import java.util.Date;

public class Request {
    String ip;
    Date date;

    public Request(String ip, Date date) {
        this.ip = ip;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Request{" +
                "ip='" + ip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        return ip != null ? ip.equals(request.ip) : request.ip == null;
    }

    @Override
    public int hashCode() {
        return ip != null ? ip.hashCode() : 0;
    }
}
