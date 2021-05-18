package br.edu.vaccineapp.external.database.entity.adapter;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.entity.VaccineModel;

import java.util.Date;

public class VaccineModelAdapter {

    public static Vaccine modelToEntity(final VaccineModel model) {
        final Vaccine entity = new Vaccine();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setDateCreate(model.getDateCreate());

        return entity;
    }

    public static VaccineModel entityToModel(final Vaccine entity) {
        final VaccineModel model = new VaccineModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setDateCreate(new Date());

        return model;
    }

}
