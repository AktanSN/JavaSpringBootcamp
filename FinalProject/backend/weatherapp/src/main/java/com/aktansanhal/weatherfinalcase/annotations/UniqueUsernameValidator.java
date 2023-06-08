package com.aktansanhal.weatherfinalcase.annotations;

import com.aktansanhal.weatherfinalcase.entity.User;
import com.aktansanhal.weatherfinalcase.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userRepository.findByUsername(value);
        if(user != null){
            return false;
        }

        return true;
    }
}
