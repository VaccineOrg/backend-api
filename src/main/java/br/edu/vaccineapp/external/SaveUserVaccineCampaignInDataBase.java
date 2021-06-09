package br.edu.vaccineapp.external;


import br.edu.vaccineapp.entity.UserVaccineCampaign;

public interface SaveUserVaccineCampaignInDataBase {
    UserVaccineCampaign execute(UserVaccineCampaign userVaccineCampaign);
}
