package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.GetVaccineByIdInDataBase;
import br.edu.vaccineapp.external.database.entity.VaccineModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.external.database.repository.VaccineRepository;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class GetVaccineByIdInDataBaseImpl implements GetVaccineByIdInDataBase {

    @Autowired
    public VaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(Long id) {
        try {
            VaccineModel vaccine = vaccineRepository.getOne(id);
            return VaccineModelAdapter.modelToEntity(vaccine);
        } catch (Exception err) {
            throw new NullPointerException("Erro de banco");
        }
    }
}
