package br.edu.vaccineapp.viewmodel;

import br.edu.vaccineapp.entity.enums.Status;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;

import java.util.Date;
import java.util.List;

public class CampaignVM {

    private String name;
//    private List<VaccineVM> vaccineList;
    private String status;
    private Long numberVaccines;
    private String dateBegin;
    private String dateEnd;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberVaccines() {
        return numberVaccines;
    }

    public void setNumberVaccines(Long numberVaccines) {
        this.numberVaccines = numberVaccines;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
