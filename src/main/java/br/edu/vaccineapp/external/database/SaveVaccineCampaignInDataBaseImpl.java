package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.SaveVaccineCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineCampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveVaccineCampaignInDataBaseImpl implements SaveVaccineCampaignInDataBase {

    @Autowired
    private VaccineCampaignRepository vaccineCampaignRepository;

    @Override
    public VaccineCampaign execute(VaccineCampaign vaccineCampaign) {
        VaccineCampaignModel model = VaccineCampaignModelAdapter.entityToModel(vaccineCampaign);
        return VaccineCampaignModelAdapter.modelToEntity(vaccineCampaignRepository.save(model));
    }
}
