package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.GetVaccineByNameInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVaccineByNameInDataBaseImpl implements GetVaccineByNameInDataBase {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(String name) {
        VaccineModel vaccine = vaccineRepository.findByName(name);
        if(vaccine ==  null) return null;
        return VaccineModelAdapter.modelToEntity(vaccine);
    }
}
