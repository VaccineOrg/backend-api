package br.edu.vaccineapp.external;

import br.edu.vaccineapp.entity.User;

public interface GetUserByIdInDataBase {
    User execute(Long id);
}
