package br.edu.vaccineapp.viewmodel.adapter;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserCampaign;
import br.edu.vaccineapp.viewmodel.UserCampaignVM;

import java.util.ArrayList;
import java.util.List;

public class UserCampaignsVMAdapter {

    public static List<UserCampaignVM> entityToViewModel (final User user, final List<UserCampaign> userCampaign){

        final List<UserCampaignVM> userCampaignVM = new ArrayList<>();

        for (UserCampaign item : userCampaign) {
            UserCampaignVM viewModel = new UserCampaignVM();
            viewModel.setUserId(user.getId());
            viewModel.setStatus(item.getCampaign().getStatus());
            viewModel.setCampaignId(item.getCampaign().getId());
            viewModel.setVaccineId(item.getVaccine().getId());
            viewModel.setCampaignName(item.getCampaign().getName());
            viewModel.setVaccineName(item.getVaccine().getName());
            userCampaignVM.add(viewModel);
        }
        return userCampaignVM;
    }
}
