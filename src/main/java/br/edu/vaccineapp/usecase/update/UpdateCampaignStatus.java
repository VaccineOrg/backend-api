package br.edu.vaccineapp.usecase.update;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.external.database.SaveCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCampaignStatus {

    @Autowired
    private SaveCampaignInDataBaseImpl saveCampaignInDataBase;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    public Campaign execute(final Campaign campaign, final String userProfile) {
        if(validateUserProfile.execute(userProfile)){
            if(campaign.getStatus().toString().equals("CLOSED")) throw new NoSuchFieldError("Não é possível mudar o status de uma camapnha finalizada");
            if(campaign.getStatus().toString().equals("IN_PROGRESS")) campaign.setStatus(Status.valueOf("CLOSED"));
            if(campaign.getStatus().toString().equals("ACCESSION")) campaign.setStatus(Status.valueOf("IN_PROGRESS"));
            if(campaign.getStatus().toString().equals("SIGN_UP")) campaign.setStatus(Status.valueOf("ACCESSION"));
            return saveCampaignInDataBase.execute(campaign);
        }
        throw new NoSuchFieldError("Erro inesperado ao alterar o status da campanha");
    }
}
