package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Campaign;

public interface SaveCampaignInDataBase {
    Campaign execute(Campaign campaign);
}
