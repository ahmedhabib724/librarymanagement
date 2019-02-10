package com.ahmed.librarymanangement.user;

import com.ahmed.librarymanangement.DataBaseManagement.DataBaseManager;
import static com.ahmed.librarymanangement.DataBaseManagement.InitializeDataBase.getNewUserId;
import com.ahmed.librarymanangement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired DataBaseManager dataBaseManager;

  @Override
  public Result getUserById(Integer userId) {
    return new Result<>(dataBaseManager.getRecordById(new Users(), userId));
  }

  @Override
  public Result getUser(String cnic, String name) {
    return null;
  }

  @Override
  public Result saveUser(Users users) {
    users.setId(getNewUserId());
    return new Result<>(dataBaseManager.saveRecord(users, users.getCnic() + "___" + users.getId()));
  }
}
