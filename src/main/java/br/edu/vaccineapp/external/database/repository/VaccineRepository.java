package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.VaccineModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<VaccineModel, Long> {
    VaccineModel findByName(String name);
}
