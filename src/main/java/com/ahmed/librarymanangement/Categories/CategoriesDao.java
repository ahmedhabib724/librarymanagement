package com.ahmed.librarymanangement.Categories;


public interface CategoriesDao {

    Categories getCategoryById(Integer id);

    Categories getCategoryByName(String name);

    Categories saveCategory(Categories categories);
}
