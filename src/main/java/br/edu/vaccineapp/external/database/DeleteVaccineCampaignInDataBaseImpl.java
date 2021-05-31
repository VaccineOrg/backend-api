package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.DeleteVaccineCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineCampaignModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteVaccineCampaignInDataBaseImpl implements DeleteVaccineCampaignInDataBase {

    @Autowired
    private VaccineCampaignRepository vaccineCampaignRepository;

    @Override
    public void execute(VaccineCampaign vaccineCampaign) {
        VaccineCampaignModel vaccineCampaignModel = VaccineCampaignModelAdapter.entityToModel(vaccineCampaign);
        vaccineCampaignRepository.delete(vaccineCampaignModel);
    }
}
