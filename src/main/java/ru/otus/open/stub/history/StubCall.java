package ru.otus.open.stub.history;

import ru.otus.open.stub.model.DealRequest;
import ru.otus.open.stub.model.DealResponse;

import java.time.LocalDateTime;
import java.util.Objects;

public class StubCall {
    private final LocalDateTime timestamp;
    private String url;
    private DealRequest bodyRequest;
    private String method;
    private DealResponse bodyResponse;

    public StubCall() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DealRequest getBodyRequest() {
        return bodyRequest;
    }

    public void setBodyRequest(DealRequest bodyRequest) {
        this.bodyRequest = bodyRequest;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public DealResponse getBodyResponse() {
        return bodyResponse;
    }

    public void setBodyResponse(DealResponse bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StubCall call = (StubCall) o;
        return Objects.equals(timestamp, call.timestamp) &&
                Objects.equals(url, call.url) &&
                Objects.equals(bodyRequest, call.bodyRequest) &&
                Objects.equals(method, call.method) &&
                Objects.equals(bodyResponse, call.bodyResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, url, bodyRequest, method, bodyResponse);
    }

    @Override
    public String toString() {
        return "StubCall{" +
                "timestamp=" + timestamp +
                ", url='" + url + '\'' +
                ", bodyRequest=" + bodyRequest +
                ", method='" + method + '\'' +
                ", bodyResponse=" + bodyResponse +
                '}';
    }
}
