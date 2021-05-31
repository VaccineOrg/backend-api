package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Campaign;

public interface GetCampaignByIdInDataBase {
    Campaign execute(Long id);
}
