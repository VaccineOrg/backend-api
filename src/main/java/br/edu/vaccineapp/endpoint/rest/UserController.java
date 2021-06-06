package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.usecase.creation.CreateUser;
import br.edu.vaccineapp.viewmodel.UserVM;
import br.edu.vaccineapp.viewmodel.adapter.UserVMAdapter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private CreateUser createUser;

    @PostMapping("/register")
    @ApiOperation(value = "Create user in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserVM> createUser(@RequestBody UserVM userVM) throws FileNotFoundException {
        final User user = createUser.execute(UserVMAdapter.viewModelToEntity(userVM));
        final UserVM result = UserVMAdapter.entityToViewModel(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
