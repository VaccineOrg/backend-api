package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVaccineCampaignUserIdRepository extends JpaRepository<UserVaccineCampaignModel, Long> {
    List<UserVaccineCampaignModel> findByCampaign_Id(Long id);
}
