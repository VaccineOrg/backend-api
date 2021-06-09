package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.UserVaccineCampaign;
import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;

import java.util.Date;

public class UserVaccineCampaignModelAdapter {

    public static UserVaccineCampaign modelToEntity (final UserVaccineCampaignModel model) {
        UserVaccineCampaign entity = new UserVaccineCampaign();

        entity.setId(model.getId());
        entity.setUser(UserModelAdapter.modelToEntity(model.getUser()));
        entity.setCampaign(CampaignModelAdapter.modelToEntity(model.getCampaign()));
        entity.setVaccine(VaccineModelAdapter.modelToEntity(model.getVaccine()));
        entity.setDateCreate(model.getDateCreate());

        return entity;
    }

    public static UserVaccineCampaignModel entityToModel (final UserVaccineCampaign entity) {
        UserVaccineCampaignModel model = new UserVaccineCampaignModel();

        model.setId(entity.getId());
        model.setUser(UserModelAdapter.entityToModel(entity.getUser()));
        model.setCampaign(CampaignModelAdapter.entityToModel(entity.getCampaign()));
        model.setVaccine(VaccineModelAdapter.entityToModel(entity.getVaccine()));
        model.setDateCreate(new Date());

        return model;
    }

}
