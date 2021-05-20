package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserCampaign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserCampaigns {

    public List<UserCampaign> execute(final User user) {
        return user.getUserCampaigns();
    }
}
