package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVaccineCampaignRepository extends JpaRepository<UserVaccineCampaignModel, Long> {

    UserVaccineCampaignModel findUserVaccineCampaignById(Long id);

}
