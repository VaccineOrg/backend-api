package br.edu.vaccineapp.usecase.validation;

import org.springframework.stereotype.Service;

@Service
public class ValidateUserProfile {

    public boolean execute(String userProfile) throws NoSuchFieldError{
        if(userProfile.equals("10")) return true;
        throw new NoSuchFieldError("Usuário inválido");
    }
}
