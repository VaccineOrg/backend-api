package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.external.database.GetUserByEmailInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmailInDataBase {

    @Autowired
    private GetUserByEmailInDataBaseImpl getUserByEmailInDataBase;

    public boolean execute(String email) {
        if(getUserByEmailInDataBase.execute(email) == null) return true;
        throw new NoSuchFieldError("Email já cadastrado!");
    }
}
