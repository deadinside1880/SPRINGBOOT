package com.example.First_project.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
                @Id Integer id,
                @NotEmpty String title,
                @Positive Integer kilometers,
                Location location,
                LocalDateTime timeStarted,
                LocalDateTime timeEnded,
                @Version Integer version) {
}
