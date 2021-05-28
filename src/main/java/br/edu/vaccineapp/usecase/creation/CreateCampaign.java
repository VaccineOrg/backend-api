package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.database.SaveCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.validation.ValidateCreateCampaign;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCampaign {

    @Autowired
    private SaveCampaignInDataBaseImpl saveCampaignInDataBase;

    @Autowired
    private ValidateCreateCampaign validateCreateCampaign;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    public Campaign execute(final String userProfile, final Campaign campaign) {
        if (validateUserProfile.execute(userProfile) && validateCreateCampaign.execute(campaign)) {
            return saveCampaignInDataBase.execute(campaign);
        }
        return null;
    }
}
