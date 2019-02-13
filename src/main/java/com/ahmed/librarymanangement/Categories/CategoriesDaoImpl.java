package com.ahmed.librarymanangement.Categories;

import com.ahmed.librarymanangement.DataBaseManagement.DataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {

  @Autowired private DataBaseManager dataBaseManager;

  @Override
  public Categories getCategoryById(Integer id) {
    return (Categories) dataBaseManager.getRecordById(Categories.class, id);
  }

  @Override
  public Categories getCategoryByName(String name) {
    return (Categories) dataBaseManager.getRecordByUniqueName(Categories.class, name);
  }

  @Override
  public Categories saveCategory(Categories categories) {
    return (Categories)
        dataBaseManager.saveRecord(categories, categories.getName() + "___" + categories.getId());
  }
}
