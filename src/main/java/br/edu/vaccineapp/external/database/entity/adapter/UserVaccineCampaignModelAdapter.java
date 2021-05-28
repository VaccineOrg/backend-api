package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.UserCampaign;
import br.edu.vaccineapp.external.database.entity.UserVaccineCampaignModel;

import java.util.Date;

public class UserVaccineCampaignModelAdapter {

    public static UserCampaign modelToEntity (final UserVaccineCampaignModel model) {
        final UserCampaign entity = new UserCampaign();
        entity.setCampaign(CampaignModelAdapter.modelToEntity(model.getCampaign()));
        entity.setVaccine(VaccineModelAdapter.modelToEntity(model.getVaccine()));
        entity.setDateCreate(model.getDateCreate());

        return entity;
    }

    public static UserVaccineCampaignModel entityToModel (final UserCampaign entity) {
        final UserVaccineCampaignModel model = new UserVaccineCampaignModel();
        model.setCampaign(CampaignModelAdapter.entityToModel(entity.getCampaign()));
        model.setVaccine(VaccineModelAdapter.entityToModel(entity.getVaccine()));
        model.setDateCreate(new Date());

        return model;
    }

}
