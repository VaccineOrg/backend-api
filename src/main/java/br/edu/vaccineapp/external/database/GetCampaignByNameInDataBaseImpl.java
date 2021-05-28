package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.GetCampaignByName;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.CampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCampaignByNameInDataBaseImpl implements GetCampaignByName {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Campaign execute(String name) {
        CampaignModel model = campaignRepository.findByName(name);
        if(model == null) return null;
        return CampaignModelAdapter.modelToEntity(model);
    }
}
