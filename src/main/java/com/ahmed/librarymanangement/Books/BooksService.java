package com.ahmed.librarymanangement.Books;

import com.ahmed.librarymanangement.utils.Result;

public interface BooksService {

  Result getBook(Integer id, String name);

  Result saveBook(Books books);

}
