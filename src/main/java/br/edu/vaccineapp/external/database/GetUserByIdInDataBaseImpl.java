package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.GetUserByIdInDataBase;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdInDataBaseImpl implements GetUserByIdInDataBase {

    @Autowired
    private UserIdRepository userIdRepository;


    @Override
    public User execute(Long id) {
        UserModel user = userIdRepository.findUserById(id);
        return UserModelAdapter.modelToEntity(user);
    }
}
