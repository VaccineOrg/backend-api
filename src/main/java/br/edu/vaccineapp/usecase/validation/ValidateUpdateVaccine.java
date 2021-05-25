package br.edu.vaccineapp.usecase.validation;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByCampaignInDataBaseImpl;
import br.edu.vaccineapp.usecase.read.GetVaccineByName;
import br.edu.vaccineapp.viewmodel.input.VaccineVMInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateUpdateVaccine {

    @Autowired
    GetVaccineByCampaignInDataBaseImpl getVaccineByCampaignInDataBase;

    @Autowired
    GetVaccineByName getVaccineByName;

    public int execute(Vaccine vaccine, VaccineVMInput vaccineVM) throws NoSuchFieldError{
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) != null && !(vaccine.getName().equals(vaccineVM.getName()))) throw new NoSuchFieldError("Vacina atrelada a uma campanha!");
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) != null) return 0;
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) == null && vaccine.getName().equals(vaccineVM.getName())) return 1;
        if(getVaccineByCampaignInDataBase.execute(vaccine.getId()) == null && !(vaccine.getName().equals(vaccineVM.getName()))){
            if(getVaccineByName.execute(vaccineVM.getName()) != null) throw new NoSuchFieldError("Nome inválido");
            return 2;
        }
        return -1;
    }
}