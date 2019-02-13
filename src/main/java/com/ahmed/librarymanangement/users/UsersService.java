package com.ahmed.librarymanangement.users;

import com.ahmed.librarymanangement.utils.Result;

public interface UsersService {
  /**
   * get user by userId
   *
   * @param id
   * @return
   */
  Result getUser(Integer id, String cnic);

  /**
   * Insert user record
   *
   * @param users
   * @return
   */
  Result saveUser(Users users);
}
