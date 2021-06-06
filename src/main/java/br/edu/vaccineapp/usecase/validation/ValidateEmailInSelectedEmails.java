package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.enums.SelectedEmails;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class ValidateEmailInSelectedEmails {

    public boolean execute(String email) throws FileNotFoundException {
        SelectedEmails emails = null;
        File directory = new File("src/main/java/br/edu/vaccineapp/json/selectEmails.json");

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(directory));
        emails = gson.fromJson(reader, SelectedEmails.class);
        if(emails.getEmail().contains(email)) return true;
        return false;
    }
}
