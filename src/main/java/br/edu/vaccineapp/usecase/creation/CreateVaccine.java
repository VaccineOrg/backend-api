package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.SaveVaccineInDataBaseImpl;
import br.edu.vaccineapp.usecase.validation.ValidateCreateVaccine;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateVaccine {

    @Autowired
    private SaveVaccineInDataBaseImpl saveVaccineInDataBase;

    @Autowired
    private ValidateCreateVaccine validateCreateVaccine;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    public Vaccine execute(final Vaccine vaccine, final String userProfile){
        if (validateCreateVaccine.execute(vaccine) && validateUserProfile.execute(userProfile)) {
            return saveVaccineInDataBase.execute(vaccine);
        }
        return null;
    }

}
