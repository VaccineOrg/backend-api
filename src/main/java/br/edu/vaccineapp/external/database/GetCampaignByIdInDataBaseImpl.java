package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.GetCampaignByIdInDataBase;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.CampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.CampaignIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCampaignByIdInDataBaseImpl implements GetCampaignByIdInDataBase {

    @Autowired
    private CampaignIdRepository campaignIdRepository;


    @Override
    public Campaign execute(Long id) {
        CampaignModel model = campaignIdRepository.findCampaignById(id);
        return CampaignModelAdapter.modelToEntity(model);
    }
}
