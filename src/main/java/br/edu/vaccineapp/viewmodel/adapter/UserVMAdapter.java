package br.edu.vaccineapp.viewmodel.adapter;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.viewmodel.UserVM;

public class UserVMAdapter {
    public static UserVM entityToViewModel(final User entity){
        final UserVM viewModel = new UserVM();
        viewModel.setId(entity.getId());
        viewModel.setUserName(entity.getUserName());
        viewModel.setEmail(entity.getEmail());
        viewModel.setPassword(entity.getPassword());
        viewModel.setEmployeeId(entity.getEmployeeId());
        return viewModel;
    }

    public static User viewModelToEntity(final UserVM viewModel){
        User entity = new User();
        entity.setId(viewModel.getId());
        entity.setUserName(viewModel.getUserName());
        entity.setPassword(viewModel.getPassword());
        entity.setEmployeeId(viewModel.getEmployeeId());
        return entity;
    }
}
