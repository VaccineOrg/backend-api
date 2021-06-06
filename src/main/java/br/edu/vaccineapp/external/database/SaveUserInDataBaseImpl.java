package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.SaveUserInDataBase;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserInDataBaseImpl implements SaveUserInDataBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User execute(User user) {
        UserModel model = UserModelAdapter.entityToModel(user);
        return UserModelAdapter.modelToEntity(userRepository.save(model));
    }
}
