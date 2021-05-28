package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.SaveCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.CampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveCampaignInDataBaseImpl implements SaveCampaignInDataBase {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Campaign execute(Campaign campaign) {
        CampaignModel model = CampaignModelAdapter.entityToModel(campaign);
        return CampaignModelAdapter.modelToEntity(campaignRepository.save(model));
    }


}
