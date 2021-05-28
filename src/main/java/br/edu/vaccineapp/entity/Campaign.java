package br.edu.vaccineapp.entity;

import br.edu.vaccineapp.entity.enums.Status;

import java.util.Date;
import java.util.List;

public class Campaign {

    private Long id;
    private String name;
    private Status status;
    private Date dateCreate;
    private Date dateBegin;
    private Date dateEnd;
    private List<VaccineCampaign> vaccineCampaigns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<VaccineCampaign> getVaccineCampaigns() {
        return vaccineCampaigns;
    }

    public void setVaccineCampaigns(List<VaccineCampaign> vaccineCampaigns) {
        this.vaccineCampaigns = vaccineCampaigns;
    }
}
