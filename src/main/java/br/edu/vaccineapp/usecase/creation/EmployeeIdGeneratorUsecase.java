package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.usecase.validation.ValidateEmailInSelectedEmails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.UUID;

@Service
public class EmployeeIdGeneratorUsecase {

    @Autowired
    private ValidateEmailInSelectedEmails validateEmailInSelectedEmails;

    public String execute(String email) throws FileNotFoundException {
        UUID uuid = UUID.randomUUID();
        String stringUUID = uuid.toString();
        return validateEmailInSelectedEmails.execute(email) ? "10-" + stringUUID : "20-" + stringUUID;
    }
}