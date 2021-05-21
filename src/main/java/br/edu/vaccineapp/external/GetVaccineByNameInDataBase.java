package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Vaccine;

public interface GetVaccineByNameInDataBase {
    Vaccine execute(String name);
}
