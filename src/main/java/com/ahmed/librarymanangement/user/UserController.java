package com.ahmed.librarymanangement.user;

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
@RequestMapping(value = "/user")
public class UserController {

  @Autowired private UserService userService;

  @RequestMapping(
      value = {"", "/user-id/{userId}"},
      method = GET)
  public Result getUser(
      @PathVariable("userId") Integer userId,
      @RequestParam(value = "cnic", required = false) String cnic,
      @RequestParam(value = "name", required = false) String name) {

    return userService.getUserById(userId);
  }

  @RequestMapping(value = "", method = POST)
  public Result saveUser(@RequestBody Users users) {
    return userService.saveUser(users);
  }
}
