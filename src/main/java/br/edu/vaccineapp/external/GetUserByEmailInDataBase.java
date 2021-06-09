package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.User;

public interface GetUserByEmailInDataBase {
    User execute(String email);
}
