package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.GetCampaignByNameInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateCreateCampaign {

    @Autowired
    private GetCampaignByNameInDataBaseImpl getCampaignByNameInDataBase;

    @Autowired
    private ValidateCampaignDate validateCampaignDate;

    public boolean execute(Campaign campaign){
        if(getCampaignByNameInDataBase.execute(campaign.getName()) == null && validateCampaignDate.execute(campaign)) return true;
        throw new NoSuchFieldError("Erro inesperado ao criar campanha");
    }
}
