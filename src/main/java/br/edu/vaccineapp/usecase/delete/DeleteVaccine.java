package br.edu.vaccineapp.usecase.delete;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.DeleteVaccineInDataBaseImpl;
import br.edu.vaccineapp.usecase.read.GetVaccineById;
import br.edu.vaccineapp.usecase.validation.ValidateDeleteVaccine;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteVaccine {

    @Autowired
    private GetVaccineById getVaccineById;

    @Autowired
    private ValidateDeleteVaccine validateDeleteVaccine;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    @Autowired
    private DeleteVaccineInDataBaseImpl deleteVaccineInDataBaseImpl;

    public boolean execute(Vaccine vaccine, String userProfile) {
        final Vaccine vaccineFound = getVaccineById.execute(vaccine.getId());
        if(validateDeleteVaccine.execute(vaccineFound) && validateUserProfile.execute(userProfile)){
            deleteVaccineInDataBaseImpl.execute(vaccineFound);
            return true;
        }
        return false;
    }

}
