package br.edu.vaccineapp.viewmodel.adapter;

import java.util.List;

public class UserCampaignsVM {

    private List<UserCampaignVM> userCampaigns;

    public List<UserCampaignVM> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserCampaignVM> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }
}
