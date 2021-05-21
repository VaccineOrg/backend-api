package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByNameInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetVaccineByName {

    @Autowired
    private GetVaccineByNameInDataBaseImpl getVaccineByNameInDataBaseImpl;

    public Vaccine execute(final String name){
        return getVaccineByNameInDataBaseImpl.execute(name);
    }

}
