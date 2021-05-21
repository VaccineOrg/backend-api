package br.edu.vaccineapp.usecase.update;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.SaveVaccineInDataBase;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import br.edu.vaccineapp.usecase.validation.ValidateUpdateVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateVaccine {

    @Autowired
    private ValidateUpdateVaccine validationUpdateVaccine;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    @Autowired
    private SaveVaccineInDataBase saveVaccineInDataBase;

    public Vaccine execute(final Vaccine vaccine, final String userProfile){

        if(validationUpdateVaccine.execute(vaccine) && validateUserProfile.execute(userProfile)){
            return saveVaccineInDataBase.execute(vaccine);
        }
        return null;
    }
}
