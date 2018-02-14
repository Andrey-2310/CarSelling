package com.a.redkovsky.carselling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;
    private String passwordConfirm;
    private boolean isCorrect;

    public RegistrationForm(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
