package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.GetUserByNameInDataBase;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByNameInDataBaseImpl implements GetUserByNameInDataBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User execute(String name) {
        UserModel user = userRepository.finduserByName(name);
        return UserModelAdapter.modelToEntity(user);
    }
}
