package com.ahmed.librarymanangement.users;

public interface UsersDao {
  Users getUsersById(Integer id);

  Users getUsersByCnic(String cnic);

  Users deleteUserById(String id);

  Users saveUser(Users users);
}
