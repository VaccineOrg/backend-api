package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.entity.VaccineModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineRepository;
import br.edu.vaccineapp.usecase.validation.ValidateUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllVaccines {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private ValidateUserProfile validateUserProfile;

    public List<Vaccine> execute(String userProfile) {
        if (validateUserProfile.execute(userProfile)) {
            final List<VaccineModel> vaccineModelList = vaccineRepository.findAll();
            final List<Vaccine> vaccineList = new ArrayList<>();

            for (VaccineModel item : vaccineModelList) {
                vaccineList.add(VaccineModelAdapter.modelToEntity(item));
            }
            return vaccineList;
        }
        return null;
    }

}
