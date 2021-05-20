package br.edu.vaccineapp.entity;

import br.edu.vaccineapp.external.database.entity.CampaignModel;
import br.edu.vaccineapp.external.database.entity.VaccineModel;

import java.util.Date;

public class VaccineCampaign {

    private Long numberVaccines;
    private Campaign campaign;
    private Vaccine vaccine;
    private Date dateCreate;

    public Long getNumberVaccines() {
        return numberVaccines;
    }

    public void setNumberVaccines(Long numberVaccines) {
        this.numberVaccines = numberVaccines;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
