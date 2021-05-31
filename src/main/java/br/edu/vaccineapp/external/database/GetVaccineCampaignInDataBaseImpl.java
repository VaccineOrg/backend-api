package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.GetVaccineCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineCampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetVaccineCampaignInDataBaseImpl implements GetVaccineCampaignInDataBase {

    @Autowired
    private VaccineCampaignRepository vaccineCampaignRepository;

    @Override
    public List<VaccineCampaign> execute(Long id) {
        List<VaccineCampaignModel> vaccineCampaignModelList = vaccineCampaignRepository.findByCampaign_Id(id);
        List<VaccineCampaign> vaccineCampaignList = new ArrayList<>();

        for(VaccineCampaignModel item : vaccineCampaignModelList){
            vaccineCampaignList.add(VaccineCampaignModelAdapter.modelToEntity(item));
        }

        return vaccineCampaignList;
    }
}
