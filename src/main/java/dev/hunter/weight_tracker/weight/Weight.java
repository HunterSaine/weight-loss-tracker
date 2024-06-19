package dev.hunter.weight_tracker.weight;

import java.time.LocalDate;
import java.time.LocalTime;

public record Weight(
        Integer id,
        Integer weight,
        LocalDate date,
        LocalTime time
) {
}
