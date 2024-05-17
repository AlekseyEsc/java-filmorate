package ru.yandex.practicum.filmorate.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FilmTest {
    private static final Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @DisplayName("Check name")
    @Test
    void checkName() {
        Film film = Film.builder()
                .name("")
                .description("description of the film")
                .releaseDate(LocalDate.of(1999, 1, 11))
                .duration(33)
                .build();

        Set<ConstraintViolation<Film>> validatorSet = validator.validate(film);
        assertFalse(validatorSet.isEmpty());
    }

    @DisplayName("Check description")
    @Test
    void checkDescription() {
        Film film = Film.builder()
                .name("Name of the film")
                .description("")
                .releaseDate(LocalDate.of(1998, 1, 1))
                .duration(33)
                .build();

        Set<ConstraintViolation<Film>> validatorSet = validator.validate(film);
        assertFalse(validatorSet.isEmpty());
    }

    @DisplayName("Check release date")
    @Test
    void checkReleaseDate() {
        Film film = Film.builder()
                .name("Name of the film")
                .description("description of the film")
                .releaseDate(LocalDate.of(988, 1, 12))
                .duration(100)
                .build();

        Set<ConstraintViolation<Film>> validatorSet = validator.validate(film);
        assertFalse(validatorSet.isEmpty());
    }

    @DisplayName("Check duration")
    @Test
    void checkDuration() {
        Film film = Film.builder()
                .name("Name of the film")
                .description("description of the film")
                .releaseDate(LocalDate.of(1997, 1, 1))
                .duration(-67)
                .build();

        Set<ConstraintViolation<Film>> validatorSet = validator.validate(film);
        assertFalse(validatorSet.isEmpty());
    }
}