package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.VaccineCampaign;

public interface SaveVaccineCampaignInDataBase {
    VaccineCampaign execute(VaccineCampaign vaccineCampaign);
}
