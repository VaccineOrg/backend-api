package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.UserVaccineCampaign;
import br.edu.vaccineapp.external.SaveUserVaccineCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserVaccineCampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserVaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserVaccineCampaignInDataBaseImpl implements SaveUserVaccineCampaignInDataBase {

    @Autowired
    private UserVaccineCampaignRepository userVaccineCampaignRepository;

    @Override
    public UserVaccineCampaign execute(UserVaccineCampaign userVaccineCampaign) {
        UserVaccineCampaignModel model = UserVaccineCampaignModelAdapter.entityToModel(userVaccineCampaign);
        return UserVaccineCampaignModelAdapter.modelToEntity(userVaccineCampaignRepository.save(model));
    }
}
