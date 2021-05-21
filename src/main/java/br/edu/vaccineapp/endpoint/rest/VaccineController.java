package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.usecase.creation.CreateVaccine;
import br.edu.vaccineapp.usecase.read.GetAllVaccines;
import br.edu.vaccineapp.viewmodel.VaccineVM;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMAdapter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Vaccine Application API")
@CrossOrigin(origins = "http://localhost:3000")
public class VaccineController {

    @Autowired
    private GetAllVaccines getAllVaccines;

    @Autowired
    private CreateVaccine createVaccine;

    @GetMapping
    @ApiOperation(value = "Return all vaccines in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VaccineVM>> getAllVaccines(@RequestHeader("user-profile") final String userProfile) {
        try {
            final List<Vaccine> vaccineList = getAllVaccines.execute(userProfile);
            final List<VaccineVM> vaccineVMList = new ArrayList<>();
            for (Vaccine item : vaccineList) {
                vaccineVMList.add(VaccineVMAdapter.entityToViewModel(item));
            }
            return ResponseEntity.status(HttpStatus.OK).body(vaccineVMList);
        }catch (Exception err) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping
    @ApiOperation(value = "Create vaccine in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VaccineVM> createVaccine (@RequestHeader("user-profile") final String userProfile, @RequestBody final VaccineVM vaccineVM) {
        try{
            final Vaccine vaccine = createVaccine.execute(VaccineVMAdapter.viewModelToEntity(vaccineVM), userProfile);
            final VaccineVM result = VaccineVMAdapter.entityToViewModel(vaccine);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception err){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(vaccineVM);
        }
    }
}
