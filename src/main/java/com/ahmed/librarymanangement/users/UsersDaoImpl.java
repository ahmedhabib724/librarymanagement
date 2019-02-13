package com.ahmed.librarymanangement.users;

import com.ahmed.librarymanangement.DataBaseManagement.DataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {

  @Autowired DataBaseManager dataBaseManager;

  @Override
  public Users getUsersById(Integer id) {
    return (Users) dataBaseManager.getRecordById(Users.class, id);
  }

  @Override
  public Users getUsersByCnic(String cnic) {
    return (Users) dataBaseManager.getRecordByUniqueName(Users.class, cnic);
  }

  @Override
  public Users deleteUserById(String id) {
    return null;
  }

  @Override
  public Users saveUser(Users users) {
    return (Users) dataBaseManager.saveRecord(users, users.getCnic() + "___" + users.getId());
  }
}
