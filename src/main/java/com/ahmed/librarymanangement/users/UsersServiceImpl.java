package com.ahmed.librarymanangement.users;

import com.ahmed.librarymanangement.DataBaseManagement.DataBaseManager;
import static com.ahmed.librarymanangement.DataBaseManagement.InitializeDataBase.getNewUserId;
import com.ahmed.librarymanangement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UsersServiceImpl implements UsersService {

  @Autowired DataBaseManager dataBaseManager;

  @Autowired UsersDao usersDao;

  @Override
  public Result getUser(Integer userId, String cnic) {
    if (userId != null) {
      return new Result<>(usersDao.getUsersById(userId));
    } else if (!StringUtils.isEmpty(cnic)) {
      return new Result<>(usersDao.getUsersByCnic(cnic));
    }
    return new Result();
  }

  @Override
  public Result saveUser(Users users) {
    users.setId(getNewUserId());
    return new Result<>(usersDao.saveUser(users));
  }
}
