package br.edu.vaccineapp.usecase.update;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.SaveVaccineInDataBase;
import br.edu.vaccineapp.usecase.validation.ValidateUpdateVaccine;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import br.edu.vaccineapp.viewmodel.input.VaccineVMInput;
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

    public Vaccine execute(final Vaccine vaccine, final VaccineVMInput vaccineVM, final String userProfile) throws NoSuchFieldError {

        if(validateUserProfile.execute(userProfile) && validationUpdateVaccine.execute(vaccine, vaccineVM) == 0){
            vaccine.setDescription(vaccineVM.getDescription());
            return saveVaccineInDataBase.execute(vaccine);
        }
        if(validateUserProfile.execute(userProfile) && validationUpdateVaccine.execute(vaccine, vaccineVM) == 1 ) {
            vaccine.setDescription(vaccineVM.getDescription());
            return saveVaccineInDataBase.execute(vaccine);
        }
        if(validateUserProfile.execute(userProfile) && validationUpdateVaccine.execute(vaccine, vaccineVM) == 2 ){
            vaccine.setName(vaccineVM.getName());
            vaccine.setDescription(vaccineVM.getDescription());
            return saveVaccineInDataBase.execute(vaccine);
        }
        return null;
    }
}
