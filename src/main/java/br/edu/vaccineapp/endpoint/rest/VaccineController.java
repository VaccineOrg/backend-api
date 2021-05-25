package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.usecase.creation.CreateVaccine;
import br.edu.vaccineapp.usecase.delete.DeleteVaccine;
import br.edu.vaccineapp.usecase.read.GetAllVaccines;
import br.edu.vaccineapp.usecase.read.GetVaccineById;
import br.edu.vaccineapp.usecase.update.UpdateVaccine;
import br.edu.vaccineapp.usecase.validation.ValidateDeleteVaccine;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMInputAdapter;
import br.edu.vaccineapp.viewmodel.input.VaccineVMInput;
import br.edu.vaccineapp.viewmodel.output.VaccineVM;
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
public class VaccineController {

    @Autowired
    private GetAllVaccines getAllVaccines;

    @Autowired
    private CreateVaccine createVaccine;

    @Autowired
    private GetVaccineById getVaccineById;

    @Autowired
    private UpdateVaccine updateVaccine;

    @Autowired
    private DeleteVaccine deleteVaccine;

    @Autowired
    private ValidateDeleteVaccine validateDeleteVaccine;

    @GetMapping
    @ApiOperation(value = "Return all vaccines in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VaccineVM>> getAllVaccines(@RequestHeader("user-profile") final String userProfile) {
            final List<Vaccine> vaccineList = getAllVaccines.execute(userProfile);
            final List<VaccineVM> vaccineVMList = new ArrayList<>();
            for (Vaccine item : vaccineList) {
                VaccineVM vaccineVM = VaccineVMAdapter.entityToViewModel(item);
                if(validateDeleteVaccine.execute(item)){
                    vaccineVM.setAbleToDelete(true);
                }else{
                    vaccineVM.setAbleToDelete(false);
                }
                vaccineVMList.add(vaccineVM);
            }
            return ResponseEntity.status(HttpStatus.OK).body(vaccineVMList);
    }

    @PostMapping
    @ApiOperation(value = "Create vaccine in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VaccineVM> createVaccine (@RequestHeader("user-profile") final String userProfile, @RequestBody final VaccineVMInput vaccineVM) throws IllegalAccessException {
            final Vaccine vaccine = createVaccine.execute(VaccineVMInputAdapter.viewModelToEntity(vaccineVM), userProfile);
            final VaccineVM result = VaccineVMAdapter.entityToViewModel(vaccine);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update vaccine in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VaccineVM> updateVaccine(@RequestHeader("user-profile") final String userProfile, @RequestBody final VaccineVMInput vaccineVM, @PathVariable final Long id){
            final Vaccine vaccine = getVaccineById.execute(id);
            final Vaccine vaccineAux = updateVaccine.execute(vaccine, vaccineVM, userProfile);
            final VaccineVM result = VaccineVMAdapter.entityToViewModel(vaccineAux);
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete vaccine in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteVaccineById(@RequestHeader("user-profile") final String userProfile, @PathVariable final Long id) {
            final Vaccine vaccine = getVaccineById.execute(id);
            final boolean result = deleteVaccine.execute(vaccine, userProfile);
            if(result) return ResponseEntity.status(HttpStatus.OK).body(null);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
