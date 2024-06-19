package dev.hunter.weight_tracker.weight;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeightController {

    private final WeightRepository weightRepository;

    public WeightController(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }
    @GetMapping("/api/v1/weights")
    List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @PostMapping("api/v1/weights")
    void newWeight(@RequestBody Weight weight) {
        weightRepository.create(weight);
    }

}
