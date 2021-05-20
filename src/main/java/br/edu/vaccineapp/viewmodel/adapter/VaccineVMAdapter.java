package br.edu.vaccineapp.viewmodel.adapter;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.viewmodel.VaccineVM;

public class VaccineVMAdapter {

    public static VaccineVM entityToViewModel(final Vaccine entity) {
        final VaccineVM viewModel = new VaccineVM();
        viewModel.setId(entity.getId());
        viewModel.setName(entity.getName());
        viewModel.setDescription(entity.getDescription());
        return viewModel;
    }

    public static Vaccine viewModelToEntity(final VaccineVM viewModel) {
        final Vaccine entity = new Vaccine();
        entity.setId(viewModel.getId());
        entity.setName(viewModel.getName());
        entity.setDescription(viewModel.getDescription());
        return entity;
    }

}
