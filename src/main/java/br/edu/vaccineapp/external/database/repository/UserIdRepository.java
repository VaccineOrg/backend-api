package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUserId(Long id);
}
