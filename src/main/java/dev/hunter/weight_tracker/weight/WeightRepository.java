package dev.hunter.weight_tracker.weight;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class WeightRepository {
    private List<Weight> weights = new ArrayList<>();

    public List<Weight> findAll() {
        return weights;
    }
    public Optional<Weight> findById(Integer id) {
        return weights.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }
    @PostConstruct
    public void Init() {
        weights.add(new Weight(1, 225, LocalDate.now(), LocalTime.now()));

    }
    public void create(Weight weight) {
        weights.add(weight);
    }

    public void update(Weight weight, Integer id ) {
        Optional<Weight> existingWeight = findById(id);
        if (existingWeight.isPresent()) {
            weights.set(weights.indexOf(existingWeight.get()), weight);
        }
        else{
            create(weight);
        }
    }
}
