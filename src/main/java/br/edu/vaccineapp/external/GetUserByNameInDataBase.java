package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.User;

public interface GetUserByNameInDataBase {

    User execute(String name);

}
