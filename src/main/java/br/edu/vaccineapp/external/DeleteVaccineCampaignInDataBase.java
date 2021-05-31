package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.VaccineCampaign;

import java.util.List;

public interface DeleteVaccineCampaignInDataBase {

    void execute(VaccineCampaign vaccineCampaign);

}
