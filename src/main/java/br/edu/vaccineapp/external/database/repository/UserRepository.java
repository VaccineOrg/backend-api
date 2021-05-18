package br.edu.vaccineapp.external.database.repository;

import br.edu.vaccineapp.external.database.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findUserByName(String name);

}
