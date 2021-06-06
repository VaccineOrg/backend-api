package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserCampaign;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserModelAdapter {

    public static User modelToEntity(final UserModel model) {
        final User entity = new User();

        entity.setId(model.getId());
        entity.setUserName(model.getUserName());
        entity.setDateCreate(model.getDateCreate());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setEmployeeId(model.getEmployeeId());
        entity.setDateCreate(model.getDateCreate());

        List<UserCampaign> userCampaignList = new ArrayList<>();
        List<UserVaccineCampaignModel> userVaccineCampaignModelList = model.getUserCampaigns();

        if(userVaccineCampaignModelList != null) {
            for (UserVaccineCampaignModel item : userVaccineCampaignModelList) {
                userCampaignList.add(UserVaccineCampaignModelAdapter.modelToEntity(item));
            }
            entity.setUserCampaigns(userCampaignList);
        }
        return entity;
    }

    public static UserModel entityToModel (final User entity) {
        final UserModel model = new UserModel();

        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setDateCreate(new Date());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setEmployeeId(entity.getEmployeeId());

        List<UserVaccineCampaignModel> userVaccineCampaignModelList = new ArrayList<>();
        List<UserCampaign> userCampaignList = entity.getUserCampaigns();

        if(userCampaignList != null) {
            for(UserCampaign item : userCampaignList) {
                userVaccineCampaignModelList.add(UserVaccineCampaignModelAdapter.entityToModel(item));
            }
            model.setUserCampaigns(userVaccineCampaignModelList);
        }

        return model;
    }

}
