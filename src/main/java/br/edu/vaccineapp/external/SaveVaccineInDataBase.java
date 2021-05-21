package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.Vaccine;

public interface SaveVaccineInDataBase {
    Vaccine execute(Vaccine vaccine);
}
