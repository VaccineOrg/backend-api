package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "VACCINEORG", name = "CAMPAIGN")
public class CampaignModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.CAMPAIGN_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.CAMPAIGN_SEQ", allocationSize = 1, name = "VACCINEORG.CAMPAIGN_SEQ")
    @Column(name="campaign_id_pk")
    private Long id;

    @Column(name = "campaign_name")
    private String name;

    @Column(name = "campaign_status")
    private String status;

    @Column(name="date_create")
    private Date dateCreate;

    @Column(name="date_begin")
    private Date dateBegin;

    @Column(name="date_end")
    private Date dateEnd;

    @OneToMany(mappedBy = "campaign")
    private List<UserVaccineCampaignModel> userCampaigns;

    @OneToMany(mappedBy="campaign")
    private List<VaccineCampaignModel> vaccineCampaigns;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public List<UserVaccineCampaignModel> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserVaccineCampaignModel> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }

    public List<VaccineCampaignModel> getVaccineCampaigns() {
        return vaccineCampaigns;
    }

    public void setVaccineCampaigns(List<VaccineCampaignModel> vaccineCampaigns) {
        this.vaccineCampaigns = vaccineCampaigns;
    }
}
