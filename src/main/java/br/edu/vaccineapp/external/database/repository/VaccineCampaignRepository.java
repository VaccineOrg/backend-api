package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineCampaignRepository extends JpaRepository<VaccineCampaignModel, Long> {
    VaccineCampaignModel findByVaccine_Id(Long id);
}
