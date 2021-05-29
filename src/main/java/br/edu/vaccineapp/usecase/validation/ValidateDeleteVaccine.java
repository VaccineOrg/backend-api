package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineIsInCampaignToValidateInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateDeleteVaccine {

    @Autowired
    private GetVaccineIsInCampaignToValidateInDataBaseImpl getVaccineByCampaignToValidateInDataBaseImpl;

    public boolean execute(Vaccine vaccine) {
        return getVaccineByCampaignToValidateInDataBaseImpl.execute(vaccine.getId());
    }
}
