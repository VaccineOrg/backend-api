package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Campaign;

public interface DeleteCampaignInDataBase {
    void execute(Campaign campaign);
}
