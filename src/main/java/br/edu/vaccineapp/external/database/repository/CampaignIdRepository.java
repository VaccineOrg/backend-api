package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.CampaignModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignIdRepository extends JpaRepository<CampaignModel, Long> {

    CampaignModel findById(String name);

}
