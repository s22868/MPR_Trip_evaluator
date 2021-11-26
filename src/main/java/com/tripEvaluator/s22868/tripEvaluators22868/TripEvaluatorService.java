package com.tripEvaluator.s22868.tripEvaluators22868;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripEvaluatorService {
    private final TripEvaluatorRepo tripEvaluatorRepo;

    public TripEvaluatorService(TripEvaluatorRepo tripEvaluatorRepo) {
        this.tripEvaluatorRepo = tripEvaluatorRepo;
    }
    public Trip getExampleTrip(){
        User testUser = new User(null,"test");
        Review testrev = new Review(null, "Test", testUser);
        List<Review> listaReview = List.of(testrev);
        Trip trip = new Trip(null,"testowa","do domu", listaReview);
        return tripEvaluatorRepo.save(trip);
    }

    public Trip addTrip(String title){
        User testUser = new User(null,title);
        Review testrev = new Review(null, title, testUser);
        List<Review> listaReview = List.of(testrev);
        Trip trip = new Trip(null, title,"na mazury", listaReview);

        return tripEvaluatorRepo.save(trip);
    }

    public List<Trip> findAll(){
        return tripEvaluatorRepo.findAll();
    }

    public Trip findById(Integer id) throws Exception {
        if(tripEvaluatorRepo.findById(id).isPresent()){
            return tripEvaluatorRepo.findById(id).get();
        }else{
            throw new Exception("Nie znaleziono Tripu o podanym id");
        }
    }

    public String delete(Integer id) throws Exception {
        if(tripEvaluatorRepo.findById(id).isPresent()){
            tripEvaluatorRepo.deleteById(id);
            return "Pomyślnie usunięto";
        }else{
            throw new Exception("Nie znaleziono Tripu o podanym id");
        }

    }


    public String addReview(Integer tripId, String content, String user) throws Exception {
        if(tripEvaluatorRepo.findById(tripId).isPresent()){
            Trip tripToAddReview = tripEvaluatorRepo.findById(tripId).get();
            User userAddingReview = new User(null, user);
            Review reviewToAdd = new Review(null, content, userAddingReview);
            tripToAddReview.addReviewToList(reviewToAdd);
            tripEvaluatorRepo.save(tripToAddReview);
            return "Pomyślnie dodano review";
        }else{
            throw new Exception("Nie znaleziono Tripu o podanym id");
        }
    }
//
//    public User addUser(String name){
//
//    }

}
