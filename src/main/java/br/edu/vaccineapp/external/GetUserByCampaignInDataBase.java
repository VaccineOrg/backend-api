package br.edu.vaccineapp.external;

import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;

import java.util.List;

public interface GetUserByCampaignInDataBase {
    List<UserVaccineCampaignModel> execute(Long id);
}
