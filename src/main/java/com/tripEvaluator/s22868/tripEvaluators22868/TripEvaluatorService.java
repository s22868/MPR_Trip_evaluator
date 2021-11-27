package com.tripEvaluator.s22868.tripEvaluators22868;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TripEvaluatorService {
    private final TripEvaluatorRepo tripEvaluatorRepo;

    public TripEvaluatorService(TripEvaluatorRepo tripEvaluatorRepo) {
        this.tripEvaluatorRepo = tripEvaluatorRepo;
    }
    public Trip getExampleTrip(){
        User testUser = new User(null,"test", "testowy nick");
        Review testrev = new Review(null, "Test", testUser, ReviewRating.CZTERY_GWIAZDKI);
        List<Review> listaReview = List.of(testrev);
        Trip trip = new Trip(null,"testowa","do domu", listaReview, 20);
        return tripEvaluatorRepo.save(trip);
    }

    public Trip addTrip(String title){
        User testUser = new User(null,title, "testowy nick");
        Review testrev = new Review(null, title, testUser, ReviewRating.TRZY_GWIAZDKI);
        List<Review> listaReview = List.of(testrev);
        Trip trip = new Trip(null, title,"na mazury", listaReview, 40);

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
            User userAddingReview = new User(null, user, "testowy nick");
            Review reviewToAdd = new Review(null, content, userAddingReview, ReviewRating.DWIE_GWIAZDKI);
            tripToAddReview.addReviewToList(reviewToAdd);
            tripEvaluatorRepo.save(tripToAddReview);
            return "Pomyślnie dodano review";
        }else{
            throw new Exception("Nie znaleziono Tripu o podanym id");
        }
    }

    public boolean isReviewEmpty(Trip trip){
        return trip.getReviewList().isEmpty();
    }

    public boolean isExpensive(Trip trip){
        return trip.getPrice() > 100;
    }

    public boolean isCheap(Trip trip){
        return trip.getPrice() < 20;
    }

    public boolean isDreamHolidays(Trip trip){
        return trip.getDestination().toLowerCase() == "mazury";
    }

    public void addReviewWithoutSave(Trip trip, Review review){
        if(trip.getReviewList() != null){
            trip.getReviewList().add(review);
        }
    }

    public void resetReviewsWithoutSave(Trip trip){
        if(trip.getReviewList() != null){
            trip.setReviewList(null);
        }
    }
    public void generateUserNewNick(User user){
        String newNickname = user.getName();
        user.setNick("NOWY "+newNickname+" NOWY");
    }
}
