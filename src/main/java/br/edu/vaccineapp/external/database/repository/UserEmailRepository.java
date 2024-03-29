package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailRepository extends JpaRepository<UserModel, Long> {
    UserModel findUserByEmail(String email);
}
