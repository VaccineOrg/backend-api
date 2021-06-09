package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.external.GetUserByCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;
import br.edu.vaccineapp.external.database.repository.UserVaccineCampaignUserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserByCampaignInDataBaseImpl implements GetUserByCampaignInDataBase {

    @Autowired
    private UserVaccineCampaignUserIdRepository userVaccineCampaignUserIdRepository;

    @Override
    public List<UserVaccineCampaignModel> execute(Long id) {
        List<UserVaccineCampaignModel> modelList = userVaccineCampaignUserIdRepository.findByCampaign_Id(id);
        return modelList;
    }
}
