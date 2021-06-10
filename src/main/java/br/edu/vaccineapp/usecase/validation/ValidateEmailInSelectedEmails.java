package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.enums.SelectedEmails;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ValidateEmailInSelectedEmails {

    public boolean execute(String email) throws FileNotFoundException {
        SelectedEmails emails = null;
        InputStream in = getClass().getResourceAsStream("/selectEmails.json");

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(in));
        emails = gson.fromJson(reader, SelectedEmails.class);
        if(emails.getEmail().contains(email)) return true;
        return false;
    }
}
