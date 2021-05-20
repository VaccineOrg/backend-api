package br.edu.vaccineapp.usecase.validation;

import org.springframework.stereotype.Service;

@Service
public class ValidateUserProfile {

    public boolean execute(String userProfile) {
        return userProfile.equals("10");
    }
}
