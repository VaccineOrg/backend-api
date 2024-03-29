package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "VACCINEORG", name = "VACCINE")
public class VaccineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.VACCINE_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.VACCINE_SEQ", allocationSize = 1, name = "VACCINEORG.VACCINE_SEQ")
    @Column(name = "vaccine_id_pk")
    private Long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_description")
    private String description;

    @Column(name = "date_create")
    private Date dateCreate;

    @OneToMany(mappedBy = "vaccine")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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
