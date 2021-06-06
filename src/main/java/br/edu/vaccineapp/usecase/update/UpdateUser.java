package br.edu.vaccineapp.usecase.update;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.SaveUserInDataBaseImpl;
import br.edu.vaccineapp.viewmodel.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    @Autowired
    private SaveUserInDataBaseImpl saveUserInDataBase;

    public User execute(final UserVM userVM, final User user){
        if(userVM.getEmail().equals(user.getEmail())) {
            user.setUserName(userVM.getUserName());
            user.setPassword(user.getPassword());
            return saveUserInDataBase.execute(user);
        }
        throw new NoSuchFieldError("Não é possível alterar o email");
    }
}
