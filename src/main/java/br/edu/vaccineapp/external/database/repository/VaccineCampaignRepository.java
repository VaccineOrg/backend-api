package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineCampaignRepository extends JpaRepository<VaccineCampaignModel, Long> {
    List<VaccineCampaignModel> findByCampaign_Id(Long id);
}
