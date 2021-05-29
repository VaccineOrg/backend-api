package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.database.SaveVaccineCampaignInDataBaseImpl;
import br.edu.vaccineapp.viewmodel.CampaignVM;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMAdapter;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CreateVaccineCampaign {

    @Autowired
    private SaveVaccineCampaignInDataBaseImpl saveVaccineCampaignImpl;

    public List<VaccineVM> execute (final Campaign campaign, final CampaignVM campaignVM) {
        List<VaccineVM> vaccineCampaignList = new ArrayList<>();
        VaccineCampaign vaccineCampaign = new VaccineCampaign();

        for(VaccineVM vaccine : campaignVM.getVaccineList()){
            vaccineCampaign.setVaccine(VaccineVMAdapter.viewModelToEntity(vaccine));
            vaccineCampaign.setCampaign(campaign);
            vaccineCampaign.setNumberVaccines(campaignVM.getNumberVaccines());
            vaccineCampaign.setDateCreate(new Date());

            VaccineCampaign vaccineCampaignInDB = saveVaccineCampaignImpl.execute(vaccineCampaign);
            vaccineCampaignList.add(VaccineVMAdapter.entityToViewModel(vaccineCampaignInDB.getVaccine()));
        }
        return vaccineCampaignList;
    }
}
