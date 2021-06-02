package br.edu.vaccineapp.usecase.delete;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.DeleteCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.validation.ValidateDeleteCampaign;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCampaign {

    @Autowired
    ValidateUserProfile validateUserProfile;

    @Autowired
    ValidateDeleteCampaign validateDeleteCampaign;

    @Autowired
    DeleteCampaignInDataBaseImpl deleteCampaignInDataBase;

    public boolean execute(Campaign campaign, String userProfile) {
        if(validateUserProfile.execute(userProfile) && validateDeleteCampaign.execute(campaign.getStatus())){
            deleteCampaignInDataBase.execute(campaign);
            return true;
        }
        throw new NoSuchFieldError("Erro ao excluir campanha");
    }

}
