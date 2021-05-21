package br.edu.vaccineapp.entity;

import br.edu.vaccineapp.entity.enums.Status;

import java.util.List;

public class Campaign {

    private Long id;
    private String name;
    private Status status;
    private String dateCreate;
    private String dateBegin;
    private String dateEnd;
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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
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

    public List<VaccineCampaign> getVaccineCampaigns() {
        return vaccineCampaigns;
    }

    public void setVaccineCampaigns(List<VaccineCampaign> vaccineCampaigns) {
        this.vaccineCampaigns = vaccineCampaigns;
    }
}
