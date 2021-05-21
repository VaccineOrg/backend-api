package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByIdInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetVaccineById {

    @Autowired
    private GetVaccineByIdInDataBaseImpl getVaccineByIdInDataBase;

    public Vaccine execute(final Long id) {
        return getVaccineByIdInDataBase.execute(id);
    }

}
