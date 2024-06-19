package dev.hunter.weight_tracker.weight;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WeightRepository {
    private List<Weight> weights = new ArrayList<>();

    public List<Weight> findAll() {
        return weights;
    }
    @PostConstruct
    public void Init() {
        weights.add(new Weight(225, LocalDate.now(), LocalTime.now()));

    }
    public void create(Weight weight) {
        weights.add(weight);
    }
}
