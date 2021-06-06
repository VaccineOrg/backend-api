package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.User;

public interface SaveUserInDataBase {
    User execute(User user);
}
