package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.GetVaccineByCampaignInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetVaccineByCampaignInDataBaseImpl implements GetVaccineByCampaignInDataBase {

    @Autowired
    private VaccineCampaignRepository vaccineCampaignRepository;

    @Override
    public List<VaccineCampaignModel> execute(Long id) {
        List<VaccineCampaignModel> modelList = vaccineCampaignRepository.findByCampaign_Id(id);

        return modelList;
    }
}
