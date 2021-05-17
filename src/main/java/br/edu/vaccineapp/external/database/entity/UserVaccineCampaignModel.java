package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "VACCINEMODEL", name = "USER_VACCINE_CAMPAIGN")
public class UserVaccineCampaignModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.USERVACCINECAMPAIGN_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.USERVACCINECAMPAIGN_SEQ", allocationSize = 1, name = "VACCINEORG.USERVACCINECAMPAIGN_SEQ")
    @Column(name = "user_vaccine_campaign_id_pk")
    private Long id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id_pk")
    private UserModel user;

    @ManyToOne
    @MapsId("campaignId")
    @JoinColumn(name = "campaign_id_pk")
    private CampaignModel campaign;

    @ManyToOne
    @MapsId("vaccineId")
    @JoinColumn(name = "vaccine_id_pk")
    private VaccineModel vaccine;

    @Column(name = "date_create")
    private Date date_create;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public CampaignModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignModel campaign) {
        this.campaign = campaign;
    }

    public VaccineModel getVaccine() {
        return vaccine;
    }

    public void setVaccine(VaccineModel vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }
}
