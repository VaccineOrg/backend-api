package br.edu.vaccineapp.viewmodel.adapter;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.viewmodel.CampaignVM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CampaignVMAdapter {

    public static CampaignVM entityToViewModel(final Campaign entity) throws ParseException {
        final CampaignVM viewModel = new CampaignVM();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        viewModel.setId(entity.getId());
        viewModel.setName(entity.getName());
        viewModel.setStatus(entity.getStatus().toString());

        viewModel.setDateBegin(sdf.format(entity.getDateBegin()));
        viewModel.setDateEnd(sdf.format(entity.getDateEnd()));

        return viewModel;
    }

    public static Campaign viewModelToEntity(final CampaignVM viewModel) throws ParseException {
        final Campaign entity = new Campaign();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        entity.setName(viewModel.getName());
        entity.setStatus(Status.valueOf(viewModel.getStatus()));

        entity.setDateBegin(sdf.parse(viewModel.getDateBegin()));
        entity.setDateEnd(sdf.parse(viewModel.getDateEnd()));
        entity.setDateCreate(new Date());

        return entity;
    }
}
