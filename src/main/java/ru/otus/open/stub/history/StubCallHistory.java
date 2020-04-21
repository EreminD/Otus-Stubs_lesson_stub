package ru.otus.open.stub.history;

import org.springframework.stereotype.Service;
import ru.otus.open.stub.model.DealRequest;
import ru.otus.open.stub.model.DealResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class StubCallHistory {
    private final static Set<StubCall> history = new HashSet<>();

    public void registerCall(DealRequest req, DealResponse resp, HttpServletRequest requestInfo) {
        StubCall call = new StubCall();
        call.setBodyRequest(req);
        call.setBodyResponse(resp);
        call.setMethod(requestInfo.getMethod());
        call.setUrl(requestInfo.getRequestURL().toString());
        history.add(call);
    }

    public void clearHistory() {
        history.clear();
    }

    public Collection<StubCall> getHistory() {
        return history;
    }


}
