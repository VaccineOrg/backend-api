package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.SaveVaccineInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveVaccineInDataBaseImpl implements SaveVaccineInDataBase {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(Vaccine vaccine) {
        VaccineModel model = VaccineModelAdapter.entityToModel(vaccine);
        return VaccineModelAdapter.modelToEntity(vaccineRepository.save(model));
    }
}
