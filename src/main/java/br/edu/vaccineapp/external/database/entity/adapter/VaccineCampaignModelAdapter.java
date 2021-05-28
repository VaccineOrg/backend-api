package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;

import java.util.Date;

public class VaccineCampaignModelAdapter {

    public static VaccineCampaign modelToEntity (final VaccineCampaignModel model) {
        final VaccineCampaign entity = new VaccineCampaign();
        entity.setDateCreate(model.getDateCreate());
        entity.setNumberVaccines(model.getNumberVaccines());
        entity.setVaccine(VaccineModelAdapter.modelToEntity(model.getVaccine()));

        return entity;
    }

    public static VaccineCampaignModel entityToModel (final VaccineCampaign entity) {
        final VaccineCampaignModel model = new VaccineCampaignModel();
        model.setDateCreate(new Date());
        model.setNumberVaccines(entity.getNumberVaccines());
        model.setVaccine(VaccineModelAdapter.entityToModel(entity.getVaccine()));

        return model;
    }
}
