package com.erecrutement.Validators;

import com.erecrutement.Entities.User.User;
import com.erecrutement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by saba on 10/12/16.
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.candidat.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.candidat.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.candidat.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalPhoneNumber", "NotEmpty.candidat.username");

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.candidat.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.candidat.username");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.candidat.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("password", "Diff.candidat.passwordConfirm");
        }
    }
}
