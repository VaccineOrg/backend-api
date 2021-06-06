package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.User;

public interface DeleteUserInDataBase {
    void execute(User user);
}
