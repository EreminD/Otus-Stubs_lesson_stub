package ru.otus.open.stub.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private StubCallHistory holder;

    @GetMapping()
    public ResponseEntity<Collection<StubCall>> history() {
        return ok(holder.getHistory());
    }

    @DeleteMapping("/clear")
    public ResponseEntity delete() {
        holder.clearHistory();
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
