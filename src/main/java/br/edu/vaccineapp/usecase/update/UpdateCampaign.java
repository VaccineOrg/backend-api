package br.edu.vaccineapp.usecase.update;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.external.database.DeleteVaccineCampaignInDataBaseImpl;
import br.edu.vaccineapp.external.database.GetVaccineCampaignInDataBaseImpl;
import br.edu.vaccineapp.external.database.SaveCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.creation.CreateVaccineCampaign;
import br.edu.vaccineapp.usecase.validation.ValidateUpdateCampaign;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import br.edu.vaccineapp.viewmodel.CampaignVM;
import br.edu.vaccineapp.viewmodel.adapter.CampaignVMAdapter;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class UpdateCampaign {

    @Autowired
    private ValidateUserProfile validateUserProfile;

    @Autowired
    private ValidateUpdateCampaign validateUpdateCampaign;

    @Autowired
    private SaveCampaignInDataBaseImpl saveCampaignInDataBase;

    @Autowired
    private DeleteVaccineCampaignInDataBaseImpl deleteVaccineCampaignInDataBase;

    @Autowired
    private GetVaccineCampaignInDataBaseImpl getVaccineCampaignInDataBase;

    @Autowired
    private CreateVaccineCampaign createVaccineCampaign;

    //TODO FALHA NA LÓGICA, A LÓGICA ATUAL EXCLUI TODAS AS USERCAMPAIGNS E RECRIA BASEADO NA CAMPAIGNVM, PORÉM ELE SÓ EXLCUI, NÃO RECRIA
    public CampaignVM execute(final String userProfile, Campaign campaign /*Campanha atual do bd*/, CampaignVM campaignVM /*Campanha editada pelo user*/) throws ParseException {
        if(!(validateUserProfile.execute(userProfile))) return null;

        if (validateUpdateCampaign.execute(campaign, campaignVM)) {
            List<VaccineCampaign> vaccineCampaignList = getVaccineCampaignInDataBase.execute(campaign.getId());
            for(VaccineCampaign item : vaccineCampaignList){
                deleteVaccineCampaignInDataBase.execute(item);
            }
            campaign = CampaignVMAdapter.viewModelToEntity(campaignVM); // Nesse momento, a campanha do banco é alterada para ficar igual ao que o user enviou
            CampaignVM campaignVMInDB = CampaignVMAdapter.entityToViewModel(saveCampaignInDataBase.execute(campaign));
            List<VaccineVM> vaccineVMList =  createVaccineCampaign.execute(campaign, campaignVM);
            campaignVMInDB.setVaccineList(vaccineVMList);
            campaignVMInDB.setNumberVaccines(campaignVM.getNumberVaccines());
            return campaignVMInDB;
        }
        throw new NoSuchFieldError("Erro inesperado ao alterar a campanha");
    }
}
