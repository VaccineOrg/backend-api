package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineIsInCampaignToValidateInDataBaseImpl;
import br.edu.vaccineapp.usecase.read.GetVaccineByName;
import br.edu.vaccineapp.viewmodel.input.VaccineVMInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateUpdateVaccine {

    @Autowired
    GetVaccineIsInCampaignToValidateInDataBaseImpl getVaccineByCampaignInDataBase;

    @Autowired
    GetVaccineByName getVaccineByName;

    public int execute(Vaccine vaccine, VaccineVMInput vaccineVM) throws NoSuchFieldError{
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) && !(vaccine.getName().equals(vaccineVM.getName()))) throw new NoSuchFieldError("Vacina atrelada a uma campanha!"); // Se está numa campanha e você tentou alterar o nome
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId())) return 0; // Se ela está atrelada a uma campanha
        if(!(getVaccineByCampaignInDataBase.execute(vaccine.getId())) && vaccine.getName().equals(vaccineVM.getName())) return 1;
        if(!(getVaccineByCampaignInDataBase.execute(vaccine.getId())) && !(vaccine.getName().equals(vaccineVM.getName()))){ // Se ela não está numa campanha e tentou mudar o nome
            if(getVaccineByName.execute(vaccineVM.getName()) != null) throw new NoSuchFieldError("Nome inválido");
            return 2;
        }
        return -1;
    }
}