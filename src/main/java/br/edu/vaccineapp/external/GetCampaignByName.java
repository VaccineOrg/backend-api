package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Campaign;

public interface GetCampaignByName {
    Campaign execute(String name);
}
