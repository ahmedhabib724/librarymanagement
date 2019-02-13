package com.ahmed.librarymanangement.Categories;

import com.ahmed.librarymanangement.DataBaseManagement.InitializeDataBase;
import static com.ahmed.librarymanangement.DataBaseManagement.InitializeDataBase.getNewCategoryId;
import com.ahmed.librarymanangement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CategoriesServiceImpl implements CategoriesService {

  @Autowired private CategoriesDao categoriesDao;

  @Override
  public Result getCategory(Integer id, String name) {
    if (id != null) {
      return new Result<>(categoriesDao.getCategoryById(id));
    } else if (!StringUtils.isEmpty(name)) {
      return new Result<>(categoriesDao.getCategoryByName(name));
    }
    return null;
  }

  @Override
  public Result saveCategory(Categories categories) {
    categories.setId(getNewCategoryId());
    return new Result<>(categoriesDao.saveCategory(categories));
  }
}
