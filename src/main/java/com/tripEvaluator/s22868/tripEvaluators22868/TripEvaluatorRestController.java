package com.tripEvaluator.s22868.tripEvaluators22868;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripEvaluatorRestController {
    private TripEvaluatorService tripEvaluatorService;

    public TripEvaluatorRestController(TripEvaluatorService tripEvaluatorService) {
        this.tripEvaluatorService = tripEvaluatorService;
    }

    @GetMapping("/test")
    public ResponseEntity<Trip> test(){
        return ResponseEntity.ok(tripEvaluatorService.getExampleTrip());
    }

    @GetMapping("/addTrip/{title}")
    public ResponseEntity<Trip> addTrip(@PathVariable("title") String title) {
        return ResponseEntity.ok(tripEvaluatorService.addTrip(title));
    }

    @GetMapping("/addReview/{tripId}/{content}/{user}")
    public ResponseEntity addReview(@PathVariable("tripId") Integer tripId, @PathVariable("content") String content, @PathVariable("user") String user){
        try{
            return ResponseEntity.ok(tripEvaluatorService.addReview(tripId, content, user));
        }catch(Exception msg){
            return ResponseEntity.ok(msg.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(tripEvaluatorService.findById(id));
        }catch(Exception msg){
            return ResponseEntity.ok(msg.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Trip>> findAll() {
        return ResponseEntity.ok(tripEvaluatorService.findAll());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(tripEvaluatorService.delete(id));
        }catch (Exception msg){
            return ResponseEntity.ok(msg.getMessage());
        }
    }
}
