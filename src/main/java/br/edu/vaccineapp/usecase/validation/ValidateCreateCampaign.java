package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.GetCampaignByNameInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateCreateCampaign {

    @Autowired
    private GetCampaignByNameInDataBaseImpl getCampaignByNameInDataBase;

    public boolean execute(Campaign campaign){
        if(getCampaignByNameInDataBase.execute(campaign.getName()) == null) return true;
        throw new NoSuchFieldError("Já existe campanha com este nome cadastrado");
    }
}
