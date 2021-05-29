package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;

import java.util.List;

public interface GetVaccineByCampaignInDataBase {
    List<VaccineCampaignModel> execute(Long id);
}
