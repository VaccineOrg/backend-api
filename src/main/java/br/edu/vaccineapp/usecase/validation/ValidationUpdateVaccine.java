package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.read.GetVaccineByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationUpdateVaccine {

    @Autowired
    GetVaccineByCampaignInDataBaseImpl getVaccineByCampaignInDataBase;

    @Autowired
    GetVaccineByName getVaccineByName;

    public boolean execute(Vaccine vaccine){
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) == null
                && getVaccineByName.execute(vaccine.getName()) == null){
            return true;
        }
        return false;
    }
}
