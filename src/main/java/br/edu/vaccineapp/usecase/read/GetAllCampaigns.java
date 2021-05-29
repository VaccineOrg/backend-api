package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.CampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.CampaignRepository;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCampaigns {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    public List<Campaign> execute(){
        final List<CampaignModel> campaignModelList = campaignRepository.findAll();
        final List<Campaign> campaignList = new ArrayList<>();

        for (CampaignModel campaignModel : campaignModelList) {
            campaignList.add(CampaignModelAdapter.modelToEntity(campaignModel));
        }

        return campaignList;
    }
}
