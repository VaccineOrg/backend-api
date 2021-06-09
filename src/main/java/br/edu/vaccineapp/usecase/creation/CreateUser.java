package br.edu.vaccineapp.usecase.creation;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.SaveUserInDataBaseImpl;
import br.edu.vaccineapp.usecase.validation.ValidateEmailInDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class CreateUser {

    @Autowired
    private EmployeeIdGenerator employeeIdGenerator;

    @Autowired
    private ValidateEmailInDataBase validateEmailInDataBase;

    @Autowired
    private SaveUserInDataBaseImpl saveUserInDataBaseImpl;

    public User execute(final User user) throws FileNotFoundException {
        if(validateEmailInDataBase.execute(user.getEmail()))
        user.setEmployeeId(employeeIdGenerator.execute(user.getEmail()));
        return saveUserInDataBaseImpl.execute(user);
    }
}
