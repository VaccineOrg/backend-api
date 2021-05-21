package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.DeleteVaccineInDateBase;
import br.edu.vaccineapp.external.database.entity.VaccineModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteVaccineInDataBaseImpl implements DeleteVaccineInDateBase {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public void execute(Vaccine vaccine) {
        VaccineModel vaccineModel = VaccineModelAdapter.entityToModel(vaccine);
        vaccineRepository.delete(vaccineModel);
    }
}
