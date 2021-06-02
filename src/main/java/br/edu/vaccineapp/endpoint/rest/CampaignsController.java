package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.external.GetCampaignByIdInDataBase;
import br.edu.vaccineapp.external.database.GetVaccineByCampaignInDataBaseImpl;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.usecase.creation.CreateCampaign;
import br.edu.vaccineapp.usecase.creation.CreateVaccineCampaign;
import br.edu.vaccineapp.usecase.delete.DeleteCampaign;
import br.edu.vaccineapp.usecase.read.GetAllCampaigns;
import br.edu.vaccineapp.usecase.update.UpdateCampaign;
import br.edu.vaccineapp.usecase.update.UpdateCampaignStatus;
import br.edu.vaccineapp.viewmodel.CampaignVM;
import br.edu.vaccineapp.viewmodel.adapter.CampaignVMAdapter;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMAdapter;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/campaigns", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignsController {

    @Autowired
    private CreateCampaign createCampaign;

    @Autowired
    private CreateVaccineCampaign createVaccineCampaign;

    @Autowired
    private GetAllCampaigns getAllCampaigns;

    @Autowired
    private GetVaccineByCampaignInDataBaseImpl getVaccineByCampaignInDataBase;

    @Autowired
    private UpdateCampaign updateCampaign;

    @Autowired
    private GetCampaignByIdInDataBase getCampaignByIdInDataBase;

    @Autowired
    private DeleteCampaign deleteCampaign;

    @Autowired
    private UpdateCampaignStatus updateCampaignStatus;


    @PostMapping
    @ApiOperation(value = "Create campaign in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CampaignVM> createCampaign(@RequestHeader("user-profile") final String userProfile, @RequestBody final CampaignVM campaignVM) throws ParseException {
        final Campaign campaign = createCampaign.execute(userProfile, CampaignVMAdapter.viewModelToEntity(campaignVM));
        final List<VaccineVM> vaccineCampaign = createVaccineCampaign.execute(campaign, campaignVM);
        CampaignVM result = CampaignVMAdapter.entityToViewModel(campaign);
        result.setNumberVaccines(campaignVM.getNumberVaccines());
        result.setVaccineList(vaccineCampaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    @ApiOperation(value = "Return all campaings in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CampaignVM>> getAllCampaigns() throws ParseException {
        final List<Campaign> campaignList = getAllCampaigns.execute();
        final List<CampaignVM> campaignVMList = new ArrayList<>();

        for(Campaign campaign : campaignList) {
            CampaignVM campaignAux =  CampaignVMAdapter.entityToViewModel(campaign);
            List<VaccineCampaignModel> vaccineCampaignModelList = getVaccineByCampaignInDataBase.execute(campaign.getId());
            List<VaccineVM> vaccineVMList = new ArrayList<>();

            for (VaccineCampaignModel vaccineCampaignModel : vaccineCampaignModelList) {
                vaccineVMList.add(VaccineVMAdapter.entityToViewModel(VaccineModelAdapter.modelToEntity(vaccineCampaignModel.getVaccine())));
                campaignAux.setNumberVaccines(vaccineCampaignModel.getNumberVaccines());
            }
            campaignAux.setVaccineList(vaccineVMList);
            campaignVMList.add(campaignAux);
        }

        return ResponseEntity.status(HttpStatus.OK).body(campaignVMList);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edit campaign in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CampaignVM> updateCampaign(@RequestHeader("user-profile") final String userProfile, @RequestBody final CampaignVM campaignVM, @PathVariable final Long id) throws ParseException {
        final Campaign campaign = getCampaignByIdInDataBase.execute(id);
        final CampaignVM result = updateCampaign.execute(userProfile, campaign, campaignVM);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete campaign in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteCampaignById(@RequestHeader("user-profile") final String userProfile, @PathVariable final Long id){
        final Campaign campaign = getCampaignByIdInDataBase.execute(id);
        if(deleteCampaign.execute(campaign, userProfile)) return ResponseEntity.status(HttpStatus.OK).body(null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @GetMapping("/status/{id}")
    @ApiOperation(value = "Update status of campaign")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CampaignVM> updateCampaignStatus(@RequestHeader("user-profile") final String userProfile, @PathVariable final Long id) throws ParseException {
        Campaign campaign = getCampaignByIdInDataBase.execute(id);
        Campaign result = updateCampaignStatus.execute(campaign, userProfile);

        CampaignVM campaignAux =  CampaignVMAdapter.entityToViewModel(result);
        List<VaccineCampaignModel> vaccineCampaignModelList = getVaccineByCampaignInDataBase.execute(result.getId());
        List<VaccineVM> vaccineVMList = new ArrayList<>();

        for (VaccineCampaignModel vaccineCampaignModel : vaccineCampaignModelList) {
            vaccineVMList.add(VaccineVMAdapter.entityToViewModel(VaccineModelAdapter.modelToEntity(vaccineCampaignModel.getVaccine())));
            campaignAux.setNumberVaccines(vaccineCampaignModel.getNumberVaccines());
        }
        campaignAux.setVaccineList(vaccineVMList);

        return ResponseEntity.status(HttpStatus.OK).body(campaignAux);
    }
}
