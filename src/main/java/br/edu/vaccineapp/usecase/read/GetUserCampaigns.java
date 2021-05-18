package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserCampaign;

import java.util.List;

public class GetUserCampaigns {

    public List<UserCampaign> execute(final User user) {
        return user.getUserCampaigns();
    }
}
