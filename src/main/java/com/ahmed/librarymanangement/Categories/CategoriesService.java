package com.ahmed.librarymanangement.Categories;

import com.ahmed.librarymanangement.utils.Result;

public interface CategoriesService {


    Result getCategory(Integer id, String name);

    Result saveCategory(Categories categories);
}
