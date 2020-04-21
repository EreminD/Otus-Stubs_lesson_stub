package ru.otus.open.stub.feed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.open.stub.model.CcyPairs;
import ru.otus.open.stub.model.PriceFeed;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static ru.otus.open.stub.model.CcyPairs.*;

@RestController
@RequestMapping("/stub/feed")
public class FeedController {


    @GetMapping("/{ccyPair}")
    public ResponseEntity<PriceFeed> getByCcyPair(@PathVariable CcyPairs ccyPair) {
        return ResponseEntity.ok(feeds.get(ccyPair));
    }

    private final Map<CcyPairs, PriceFeed> feeds = new HashMap<>();

    @PostConstruct
    private void fill(){
        feeds.put(USD_RUB, new PriceFeed(USD_RUB,81.05));
        feeds.put(GBP_RUB, new PriceFeed(GBP_RUB,95.00));
        feeds.put(EUR_RUB, new PriceFeed(EUR_RUB,88.47));
        feeds.put(JPY_RUB, new PriceFeed(JPY_RUB,70.71));
        feeds.put(EUR_USD, new PriceFeed(EUR_USD,1.08));
    }



    @PostMapping("/add")
    public ResponseEntity<PriceFeed> getByCcyPair(@RequestBody PriceFeed newFeed){
        CcyPairs pair = CcyPairs.valueOf(newFeed.getName().replace("/", "_"));
        feeds.put(pair, newFeed);
        System.out.println(feeds);
        return ResponseEntity.ok().build();
    }





}
