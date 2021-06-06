package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.external.database.GetUserByIdInDataBaseImpl;
import br.edu.vaccineapp.usecase.creation.CreateUser;
import br.edu.vaccineapp.usecase.delete.DeleteUser;
import br.edu.vaccineapp.usecase.update.UpdateUser;
import br.edu.vaccineapp.usecase.validation.ValidateLogin;
import br.edu.vaccineapp.viewmodel.UserVM;
import br.edu.vaccineapp.viewmodel.adapter.UserVMAdapter;
import br.edu.vaccineapp.viewmodel.input.LoginVM;
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

    @Autowired
    private ValidateLogin validateLogin;

    @Autowired
    private GetUserByIdInDataBaseImpl getUserByIdInDataBase;

    @Autowired
    private UpdateUser updateUser;

    @Autowired
    private DeleteUser deleteUser;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user's informations by id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserVM> getUser(@PathVariable final Long id) {
        User user = getUserByIdInDataBase.execute(id);
        UserVM userVM = UserVMAdapter.entityToViewModel(user);
        return ResponseEntity.status(HttpStatus.OK).body(userVM);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Create user in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserVM> createUser(@RequestBody UserVM userVM) throws FileNotFoundException {
        final User user = createUser.execute(UserVMAdapter.viewModelToEntity(userVM));
        final UserVM result = UserVMAdapter.entityToViewModel(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login service, returns a user object json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserVM> login(@RequestBody LoginVM loginVM) {
        final User user = validateLogin.execute(loginVM);
        final UserVM result = UserVMAdapter.entityToViewModel(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update user in database")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserVM> updateUser(@PathVariable final Long id, @RequestBody UserVM userVM) {
        final User user = getUserByIdInDataBase.execute(id);
        final User updatedUser = updateUser.execute(userVM, user);
        final UserVM result = UserVMAdapter.entityToViewModel(updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if(deleteUser.execute(id)) return ResponseEntity.status(HttpStatus.OK).body(null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
