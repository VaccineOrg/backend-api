package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByCampaignInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateDeleteVaccine {

    @Autowired
    private GetVaccineByCampaignInDataBaseImpl getVaccineByCampaignInDataBaseImpl;

    public boolean execute(Vaccine vaccine) {
        return getVaccineByCampaignInDataBaseImpl.execute(vaccine.getId());
    }
}
