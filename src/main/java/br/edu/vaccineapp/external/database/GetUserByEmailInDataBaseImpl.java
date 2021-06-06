package br.edu.vaccineapp.external.database;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.GetUserByEmailInDataBase;
import br.edu.vaccineapp.external.database.entity.UserModel;
import br.edu.vaccineapp.external.database.entity.adapter.UserModelAdapter;
import br.edu.vaccineapp.external.database.repository.UserEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByEmailInDataBaseImpl implements GetUserByEmailInDataBase {

    @Autowired
    private UserEmailRepository userEmailRepository;

    @Override
    public User execute(String email) {
        UserModel user = userEmailRepository.findUserByEmail(email);
        if(user == null) return null;
        return UserModelAdapter.modelToEntity(user);
    }
}
