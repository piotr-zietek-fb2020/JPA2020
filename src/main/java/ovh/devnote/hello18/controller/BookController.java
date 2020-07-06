package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.services.AutorService;
import ovh.devnote.hello18.services.BookService;
import ovh.devnote.hello18.services.KategoriaService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private KategoriaService kategoriaService;
    @Autowired
    private AutorService autorService;

    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listBook(Model model, @RequestParam(value = "autor", required = false) Integer autorid,
                           @RequestParam(value = "kategoria", required = false) Integer kategoriaid, @RequestParam(value = "tytul", required = false) String tytul) {
        List<Ksiazka> books;
        if (autorid != null) {
            books = bookService.getBooksByAutor(autorid);
        } else if (kategoriaid != null) {
            books = bookService.getBooksByKategoria(kategoriaid);
        } else {
            books = bookService.getBooks();
        }
        model.addAttribute("books", books);
        return "bookslist";
    }

    @GetMapping("/list/szukaj")
    public String listBook(HttpServletRequest request, Model model) {
        String tytul = request.getParameter("nazwa_szukana");
        List<Ksiazka> books = bookService.getBooksByTytul(tytul);
        model.addAttribute("books", books);
        return "bookslist";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/formadd")
    public String addForm(Model model)
    {
        Ksiazka book = new Ksiazka();
        model.addAttribute("book",book);
        model.addAttribute("kategorie", kategoriaService.getKategorie());
        model.addAttribute("autorzy", autorService.getAutorzy());
        return "addbookform";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/saveBook")
    public ModelAndView saveBook(@ModelAttribute("book") Ksiazka ksiazka, @ModelAttribute("kategoria") Kategoria kategoria)
    {
       List<Integer> autorzyId = ksiazka.getListaAutorow();
        System.out.println(autorzyId);
        for (int id : autorzyId) {
            Autor autor = autorService.getAutor(id);
            ksiazka.addAutor(autor);
        }
        bookService.saveBook(ksiazka);
        return new ModelAndView("redirect:/admin/books/list");
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/updateBookForm")
    public String updateBookForm(@RequestParam("bookId")int bookid, Model model){
        Ksiazka ksiazka = bookService.getBook(bookid);
/*        Stream<Integer> stream = ksiazka.getAutorzy().stream().map(Autor::getId);
        List<Integer> autorzyId = stream.collect(Collectors.toList());*/
        model.addAttribute("book",ksiazka);
        model.addAttribute("kategorie", kategoriaService.getKategorie());
        model.addAttribute("autorzy", autorService.getAutorzy());
/*        model.addAttribute("autorzyid", autorzyId);*/
        return "addbookform";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deleteBookForm")
    public ModelAndView deleteBookForm(@RequestParam("bookId")int bookid, Model model){
        bookService.deleteBook(bookid);
        return new ModelAndView("redirect:/admin/books/list");
    }

}
