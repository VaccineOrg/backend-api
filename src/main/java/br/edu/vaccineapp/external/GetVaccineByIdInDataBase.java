package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Vaccine;

public interface GetVaccineByIdInDataBase {
    Vaccine execute(Long id);
}
