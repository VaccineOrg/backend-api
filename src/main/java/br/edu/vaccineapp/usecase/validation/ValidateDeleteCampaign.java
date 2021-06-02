package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.enums.Status;
import org.springframework.stereotype.Service;

@Service
public class ValidateDeleteCampaign {

    public boolean execute(Status status){
        if(status.equals(Status.valueOf("SIGN_UP"))) return true;
        throw new NoSuchFieldError("Não é possível excluir uma campanha que não esteja com status 'CADASTRADA' ");
    }
}

