package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineIsInCampaignRepository extends JpaRepository<VaccineCampaignModel, Long> {

    boolean existsByVaccineId(Long id);

}
