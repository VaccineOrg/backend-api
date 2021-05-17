package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "VACCINEMODEL", name = "CAMPAIGN")
public class CampaignModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.CAM_SEQ")
    @SequenceGenerator(sequenceName = "VACCINE.CAM_SEQ", allocationSize = 1, name = "VACCINE.CAM_SEQ")
    @Column(name="campaign_id_pk")
    private Long id;

    @Column(name = "campaign_name")
    private String name;

    @Column(name = "campaign_status")
    private String status;

    @Column(name="date_create")
    private String dateCreate;

    @Column(name="date_begin")
    private String dateBegin;

    @Column(name="date_end")
    private String dateEnd;

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
