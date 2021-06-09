package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.viewmodel.input.LoginVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateLogin {

    @Autowired
    private ValidateLoginEmail validateLoginEmail;

    public User execute(LoginVM loginVM) {
        User user = validateLoginEmail.execute(loginVM);
        if(loginVM.getPassword().equals(user.getPassword())) return user;
        throw new NoSuchFieldError("Senha incorreta!");
    }
}
