package com.erecrutement.ViewModels;

import com.erecrutement.Entities.Candidat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Bean;

/**
 * Created by saba on 08/12/16.
 */

public class CandidatSignupForm extends Candidat{

    @NotEmpty
    private String passwordConfirm;

    public CandidatSignupForm() {
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
