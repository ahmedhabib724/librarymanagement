package com.ahmed.librarymanangement.users;

import com.ahmed.librarymanangement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

  @Autowired private UsersService usersService;

  /**
   * get user on the basis of userId or search user on the basis of name and cnic
   *
   * @param id
   * @param cnic
   * @return
   */
  @RequestMapping(
      value = {"", "/user-id/{userId}"},
      method = GET)
  public Result getUser(
      @PathVariable(value = "userId", required = false) Integer id,
      @RequestParam(value = "cnic", required = false) String cnic) {

    return usersService.getUser(id, cnic);
  }

  /**
   * Insert user record
   *
   * @param users
   * @return
   */
  @RequestMapping(value = "", method = POST)
  public Result saveUser(@RequestBody Users users) {
    return usersService.saveUser(users);
  }
}
