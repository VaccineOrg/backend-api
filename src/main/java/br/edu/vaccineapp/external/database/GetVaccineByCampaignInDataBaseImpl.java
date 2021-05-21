package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.GetVaccineByCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineCampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVaccineByCampaignInDataBaseImpl implements GetVaccineByCampaignInDataBase {

    @Autowired
    private VaccineCampaignRepository vaccineCampaignRepository;

    @Override
    public VaccineCampaign execute(Long id) {
        VaccineCampaignModel vaccineCampaignModel = vaccineCampaignRepository.findByVaccine_Id(id);
        if(vaccineCampaignModel == null) return null;
        return VaccineCampaignModelAdapter.modelToEntity(vaccineCampaignModel);
    }
}
