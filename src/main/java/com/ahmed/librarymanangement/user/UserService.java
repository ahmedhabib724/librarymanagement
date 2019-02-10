package com.ahmed.librarymanangement.user;

import com.ahmed.librarymanangement.utils.Result;

public interface UserService {
  Result getUserById(Integer userId);

  Result getUser(String cnic, String name);

  Result saveUser(Users users);
}
