package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.VaccineCampaign;

public interface GetVaccineByCampaignInDataBase {
    VaccineCampaign execute(Long id);
}
