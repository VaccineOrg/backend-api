package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.VaccineCampaign;

import java.util.List;

public interface GetVaccineCampaignInDataBase {

    List<VaccineCampaign> execute(Long id);

}
