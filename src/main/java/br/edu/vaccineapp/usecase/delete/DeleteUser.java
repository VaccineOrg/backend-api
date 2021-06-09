package br.edu.vaccineapp.usecase.delete;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.DeleteUserInDataBaseImpl;
import br.edu.vaccineapp.external.database.GetUserByIdInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {

    @Autowired
    private DeleteUserInDataBaseImpl deleteUserInDataBase;

    @Autowired
    private GetUserByIdInDataBaseImpl getUserByIdInDataBaseImpl;

    public boolean execute(Long id){
        final User userFound = getUserByIdInDataBaseImpl.execute(id);
        deleteUserInDataBase.execute(userFound);
        return true;
    }
}
