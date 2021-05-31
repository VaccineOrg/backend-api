package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.GetCampaignByNameInDataBaseImpl;
import br.edu.vaccineapp.viewmodel.CampaignVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ValidateUpdateCampaign {

    @Autowired
    private GetCampaignByNameInDataBaseImpl getCampaignByNameInDataBase;

    @Autowired
    private ValidateCampaignDate validateCampaignDate;

    public boolean execute(Campaign campaign, CampaignVM campaignVM) throws ParseException {
        if(campaign.getStatus().toString().equals("SIGN_UP") && campaignVM.getStatus().equals(campaign.getStatus().toString())) return true;
        throw new NoSuchFieldError("Impossivel alterar o status");
    }
}
