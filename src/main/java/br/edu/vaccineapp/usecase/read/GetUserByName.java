package br.edu.vaccineapp.usecase.read;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.GetUserByNameInDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByName {

    @Autowired
    private GetUserByNameInDataBaseImpl getUserByNameInDataBaseImpl;

    public User execute(final String userName) {
        return getUserByNameInDataBaseImpl.execute(userName);
    }

}
