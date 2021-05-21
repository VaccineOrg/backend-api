package br.edu.vaccineapp.viewmodel.adapter;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.viewmodel.input.VaccineVMInput;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;

public class VaccineVMInputAdapter {

    public static VaccineVMInput entityToViewModel(final Vaccine entity) {
        final VaccineVMInput viewModel = new VaccineVMInput();
        viewModel.setName(entity.getName());
        viewModel.setDescription(entity.getDescription());
        return viewModel;
    }

    public static Vaccine viewModelToEntity(final VaccineVMInput viewModel) {
        final Vaccine entity = new Vaccine();
        entity.setName(viewModel.getName());
        entity.setDescription(viewModel.getDescription());
        return entity;
    }

}
