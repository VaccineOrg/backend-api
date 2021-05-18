package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.VaccineCampaign;
import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.external.database.entity.CampaignModel;

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

        return entity;
    }

}
