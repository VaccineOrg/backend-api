package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.DeleteCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.CampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.CampaignIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCampaignInDataBaseImpl implements DeleteCampaignInDataBase {

    @Autowired
    CampaignIdRepository campaignIdRepository;

    @Override
    public void execute(Campaign campaign) {
        CampaignModel campaignModel = CampaignModelAdapter.entityToModel(campaign);
        campaignIdRepository.delete(campaignModel);
    }
}
