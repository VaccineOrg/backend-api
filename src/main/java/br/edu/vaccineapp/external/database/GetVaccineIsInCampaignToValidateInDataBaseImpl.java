package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.external.GetVaccineIsInCampaignInDataBase;
import br.edu.vaccineapp.external.database.repository.VaccineIsInCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVaccineIsInCampaignToValidateInDataBaseImpl implements GetVaccineIsInCampaignInDataBase {

    @Autowired
    private VaccineIsInCampaignRepository vaccineIsInCampaignRepository;

    @Override
    public boolean execute(Long id) {
        if(vaccineIsInCampaignRepository.existsByVaccineId(id)) return true;
        return false;
    }
}
