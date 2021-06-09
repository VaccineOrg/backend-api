package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.GetUserByEmailInDataBaseImpl;
import br.edu.vaccineapp.viewmodel.input.LoginVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateLoginEmail {

    @Autowired
    private GetUserByEmailInDataBaseImpl getUserByEmailInDataBase;

    public User execute(LoginVM loginVM){
        User user = getUserByEmailInDataBase.execute(loginVM.getEmail());
        if(user == null) throw new NoSuchFieldError("Usuário não encontrado");
        return user;
    }
}
