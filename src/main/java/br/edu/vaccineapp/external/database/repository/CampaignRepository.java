package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.CampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<CampaignModel, Long> {

    CampaignModel findByName(String name);

}
