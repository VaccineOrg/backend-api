package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetVaccineByCampaignInDataBaseImpl;
import br.edu.vaccineapp.external.database.entity.VaccineCampaignModel;
import br.edu.vaccineapp.external.database.entity.adapter.VaccineModelAdapter;
import br.edu.vaccineapp.usecase.creation.CreateCampaign;
import br.edu.vaccineapp.usecase.creation.CreateVaccineCampaign;
import br.edu.vaccineapp.usecase.read.GetAllCampaigns;
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
}
