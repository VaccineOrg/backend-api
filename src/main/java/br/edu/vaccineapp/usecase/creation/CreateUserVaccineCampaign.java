package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserVaccineCampaign;
import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.SaveUserVaccineCampaignInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserVaccineCampaign {

    @Autowired
    private SaveUserVaccineCampaignInDataBaseImpl saveUserVaccineCampaignInDataBase;

    public UserVaccineCampaign execute(final User user, final Campaign campaign, final Vaccine vaccine) {
        if(!(campaign.getStatus().toString().equals("ACCESSION"))) throw new NoSuchFieldError("Campanha não está em período de adesão!");
        UserVaccineCampaign userVaccineCampaign = new UserVaccineCampaign();
        userVaccineCampaign.setUser(user);
        userVaccineCampaign.setVaccine(vaccine);
        userVaccineCampaign.setCampaign(campaign);
        return saveUserVaccineCampaignInDataBase.execute(userVaccineCampaign);
    }
}
