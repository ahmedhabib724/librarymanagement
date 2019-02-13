package com.ahmed.librarymanangement.Books;

import static com.ahmed.librarymanangement.DataBaseManagement.InitializeDataBase.getNewBookId;
import com.ahmed.librarymanangement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class BooksServiceImpl implements BooksService {

  @Autowired private BooksDao booksDao;

  @Override
  public Result getBook(Integer id, String name) {
    if (id != null) {
      return new Result<>(booksDao.getBookById(id));
    } else if (!isEmpty(name)) {
      return new Result<>(booksDao.getBookByName(name));
    }
    return null;
  }

  @Override
  public Result saveBook(Books books) {
    books.setId(getNewBookId());
    return new Result<>(booksDao.saveBook(books));
  }
}
