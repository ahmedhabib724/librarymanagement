package com.ahmed.librarymanangement.Books;

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
@RequestMapping(value = "/books")
public class BooksController {

  @Autowired private BooksService booksService;

  @RequestMapping(
      value = {"", "/book-id/{bookId}"},
      method = GET)
  public Result getBook(
      @PathVariable(value = "bookId", required = false) Integer id,
      @RequestParam(value = "name", required = false) String name) {
    return booksService.getBook(id, name);
  }

  @RequestMapping(value = "", method = POST)
  public Result saveBook(@RequestBody Books books) {
    return booksService.saveBook(books);
  }
}
