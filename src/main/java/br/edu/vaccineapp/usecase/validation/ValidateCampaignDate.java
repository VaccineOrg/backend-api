package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Campaign;
import org.springframework.stereotype.Service;

@Service
public class ValidateCampaignDate {

    public boolean execute(Campaign campaign){
        if(campaign.getDateEnd().after(campaign.getDateBegin())) return true;
        throw new NoSuchFieldError("Data de início posterior a de término");
    }
}
