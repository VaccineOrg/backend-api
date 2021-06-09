package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.DeleteUserInDataBase;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserInDataBaseImpl implements DeleteUserInDataBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(User user) {
        UserModel userModel = UserModelAdapter.entityToModel(user);
        userRepository.delete(userModel);
    }
}
