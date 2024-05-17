package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.yandex.practicum.filmorate.validator.FilmReleaseDate;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
public class Film {
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Size(min = 3, max = 200)
    private String description;

    @FilmReleaseDate
    private LocalDate releaseDate;

    @NotNull
    @Positive
    private Integer duration;
}
