package ru.yandex.practicum.filmorate.model;

import jakarta.validation.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @DisplayName("Check email")
    @Test
    void checkEmail() {
        User user = User.builder()
                .email("gmail.com")
                .login("login")
                .name("name")
                .birthday(LocalDate.of(1999, 11, 11))
                .build();

        Set<ConstraintViolation<User>> validatorSet = validator.validate(user);
        assertFalse(validatorSet.isEmpty());
    }

    @DisplayName("Check login")
    @Test
    void checkLogin() {
        User user = User.builder()
                .email("email@gmail.com")
                .login("")
                .name("name")
                .birthday(LocalDate.of(1999, 11, 11))
                .build();

        Set<ConstraintViolation<User>> validatorSet = validator.validate(user);
        assertFalse(validatorSet.isEmpty());
    }


    @DisplayName("Check birthday")
    @Test
    void checkBirthday() {
        User user = User.builder()
                .email("email@gmail.com")
                .login("login")
                .name("name")
                .birthday(LocalDate.of(2999, 11, 11))
                .build();

        Set<ConstraintViolation<User>> validatorSet = validator.validate(user);
        assertFalse(validatorSet.isEmpty());
    }
}