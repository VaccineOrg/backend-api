package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.usecase.read.GetVaccineByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateCreateVaccine {

    @Autowired
    private GetVaccineByName getVaccineByName;

    public boolean execute(Vaccine vaccine) throws NoSuchFieldError{
        if(getVaccineByName.execute(vaccine.getName()) == null) return true;
        throw new NoSuchFieldError("Já existe vacina com este nome cadastrado");
    }

}
