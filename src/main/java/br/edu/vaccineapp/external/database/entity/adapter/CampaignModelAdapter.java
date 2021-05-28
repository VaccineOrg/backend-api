package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CampaignModelAdapter {

    public static Campaign modelToEntity(final CampaignModel model){
        final Campaign entity = new Campaign();
        entity.setId(model.getId());
        entity.setStatus(Status.valueOf(model.getStatus()));
        entity.setName(model.getName());
        entity.setDateCreate(model.getDateCreate());
        entity.setDateBegin(model.getDateBegin());
        entity.setDateEnd(model.getDateEnd());

//        List<VaccineCampaign> vaccineCampaignList = new ArrayList<>();
//        List<VaccineCampaignModel> vaccineCampaignModelList = model.getVaccineCampaigns();
//
//        for(VaccineCampaignModel item : vaccineCampaignModelList) {
//            vaccineCampaignList.add(VaccineCampaignModelAdapter.modelToEntity(item));
//        }
//        entity.setVaccineCampaigns(vaccineCampaignList);

        return entity;
    }

    public static CampaignModel entityToModel(final Campaign entity) {
        final CampaignModel model = new CampaignModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setStatus(entity.getStatus().toString());
        model.setDateCreate(new Date());
        model.setDateBegin(entity.getDateBegin());
        model.setDateEnd(entity.getDateEnd());

//        List<VaccineCampaignModel> vaccineCampaignModelList = new ArrayList<>();
//        List<VaccineCampaign> vaccineCampaignList = entity.getVaccineCampaigns();
//
//        for(VaccineCampaign item : vaccineCampaignList) {
//            vaccineCampaignModelList.add(VaccineCampaignModelAdapter.entityToModel(item));
//        }
//        model.setVaccineCampaigns(vaccineCampaignModelList);

        return model;
    }
}
