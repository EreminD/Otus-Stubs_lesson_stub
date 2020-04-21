package ru.otus.open.stub.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.open.stub.history.StubCallHistory;
import ru.otus.open.stub.model.DealRequest;
import ru.otus.open.stub.model.DealResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stub/forex")
public class ForexController {


    @Autowired
    private StubCallHistory history;

    private final static double fee = 0.01;



    @PostMapping(value = "/deal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DealResponse> deal(@RequestBody DealRequest request, HttpServletRequest requestInfo) {

        double feeCharge = request.getAmountInCcy1() * fee;
        double totalToDeal = request.getAmountInCcy1() - feeCharge;
        double totalChanged = request.getSize() * totalToDeal/request.getAmountInCcy1();
        DealResponse response = new DealResponse(request.getPair(), totalChanged, feeCharge);

        history.registerCall(request, response, requestInfo);
        return ResponseEntity.ok(response);
    }









}
