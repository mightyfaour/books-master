package africa.semicolon.books.controller;
import africa.semicolon.books.model.data.Book;
import africa.semicolon.books.services.BookServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/books")
    public String list(Model model){
        model.addAttribute(bookServices.findAll());
        return "list";
    }

    @PostMapping("/book/save")
    public String save(@RequestBody Book book) {
        bookServices.save(book);
        return "Saved book successfully!";
    }

    @GetMapping("/book/search")
    public String search(@RequestParam("term") String term, Model model){
        if(StringUtils.isEmpty(term)){
            return "redirect:/book";
        }
        model.addAttribute("books",bookServices.search(term));
        return "list";
    }
}
