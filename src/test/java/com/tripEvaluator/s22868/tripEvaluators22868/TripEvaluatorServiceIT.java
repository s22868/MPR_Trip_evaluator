package com.tripEvaluator.s22868.tripEvaluators22868;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TripEvaluatorServiceIT {

    @MockBean
    private TripEvaluatorRepo tripEvaluatorRepo;

    @Autowired
    private TripEvaluatorService tripService;

    @Test
    void shouldIsExpensive() {
        //GIVEN
        Trip trip = new Trip(null, "test title", "test dest", List.of(), 50);
        //WHEN
        tripService.isExpensive(trip);
        //THEN
        assertThat(trip.getPrice() > 100).isEqualTo(false);
    }

    @Test
    void shouldIsCheap() {
        //GIVEN
        Trip trip = new Trip(null, "test title", "test dest", List.of(), 10);
        //WHEN
        tripService.isCheap(trip);
        //THEN
        assertThat(trip.getPrice() < 20).isEqualTo(true);
    }

    @Test
    void shouldIsDreamHolidays() {
        //GIVEN
        Trip trip = new Trip(null, "test title", "mazury", List.of(), 50);
        //WHEN
        tripService.isDreamHolidays(trip);
        //THEN
        assertThat(trip.getDestination()).isEqualTo("mazury");
    }

    @Test
    void shouldAddReviewWithoutSave() {
        //GIVEN
        Trip trip = new Trip(null, "test title", "test dest", List.of(), 50);
        //WHEN
        //THEN
    }

    @Test
    void shouldGenerateUserNewNick() {
        //GIVEN
        Trip trip = new Trip(null, "test title", "test dest", List.of(), 50);
        //WHEN
        //THEN
    }

    @Test
    void shouldFindById() throws Exception {
        Mockito.when(tripEvaluatorRepo.findById(any()))
                .thenReturn(Optional.of(new Trip()));

        Trip tripById = tripService.findById(1);

        assertThat(tripById).isNotNull();
    }

    @Test
    void shouldNotFindById() {
        Mockito.when(tripEvaluatorRepo.findById(any()))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(Exception.class).isThrownBy(() -> tripService.findById(100));

    }

    @Test
    void deleteTripById() throws Exception {
        Mockito.when(tripEvaluatorRepo.findById(any()))
                .thenReturn(Optional.of(new Trip()));

        String deleted = tripService.delete(1);
        assertThat(deleted).isEqualTo("Pomyślnie usunięto");

//        tripService.delete(1);
//        sprawdza czy metoda zostala wywolana raz
//        verify(tripEvaluatorRepo).deleteById(any());

    }

    @Test
    void getAllTrips() {
        Mockito.when(tripEvaluatorRepo.findAll())
                .thenReturn(List.of(new Trip(), new Trip()));
        List<Trip> list = tripService.findAll();
        assertThat(list).hasSize(2);
    }

    @Test
    void tripExist() {
        Mockito.when(tripEvaluatorRepo.existsById(any()))
                .thenReturn(true);

        boolean exist = tripEvaluatorRepo.existsById(1);
        assertThat(exist).isTrue();
    }
}
