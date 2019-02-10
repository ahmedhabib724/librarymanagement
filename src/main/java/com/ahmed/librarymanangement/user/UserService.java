package com.ahmed.librarymanangement.user;

import com.ahmed.librarymanangement.utils.Result;

public interface UserService {
  /**
   * get user by userId
   * @param userId
   * @return
   */
  Result getUserById(Integer userId);

  /**
   * search user by user name or cnic
   * @param cnic
   * @param name
   * @return
   */
  Result getUser(String cnic, String name);

  /**
   * Insert user record
   * @param users
   * @return
   */
  Result saveUser(Users users);
}
