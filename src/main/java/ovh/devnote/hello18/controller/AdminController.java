package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.devnote.hello18.dao.WiadomoscDAO;
import ovh.devnote.hello18.services.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    BookService bookService;
    @Autowired
    AutorService autorService;
    @Autowired
    KategoriaService kategoriaService;
    @Autowired
    WiadomoscService wiadomoscService;
    @Autowired
    SubskrybcjaService subskrybcjaService;
    @Autowired
    ZamowienieService zamowienieService;

    @GetMapping("/")
    public String admin() {
        return "adminPage";
    }

    @GetMapping("/sklep")
    public String powrotDoSklepu() {
        return "redirect:/";
    }

    @GetMapping("/add-ksiazka")
    public String dodajKsiazke() {
        return "redirect:/books/formadd";
    }

    @GetMapping("/add-kategoria")
    public String dodajKategorie() {
        return "redirect:/kategorie/formadd";
    }

    @GetMapping("/add-autor")
    public String dodajAutora() {
        return "redirect:/autorzy/formadd";
    }

    @GetMapping("/books/list")
    public String getAllBooks(Model model) {
         model.addAttribute("books", bookService.getBooks());
         return "adminBookList";
    }

    @GetMapping("/autorzy/list")
    public String getAllAutorzy(Model model) {
        model.addAttribute("autorzy", autorService.getAutorzy());
        return "adminAutorList";
    }

    @GetMapping("/kategorie/list")
    public String getAllKategorie(Model model) {
        model.addAttribute("kategorie", kategoriaService.getKategorie());
        return "adminKategoriaList";
    }

    @GetMapping("/wiadomosci/list")
    public String getAllWiadomosci(Model model) {
        model.addAttribute("wiadomosci", wiadomoscService.getAll());
        return "adminWiadomoscList";
    }

    @GetMapping("/subskrybcje/list")
    public String getAllSubskrybcje(Model model) {
        model.addAttribute("subskrybcje", subskrybcjaService.getAll());
        return "adminSubskrybcjaList";
    }

    @GetMapping("/zamowienia/list")
    public String getAllZamowienia(Model model) {
        model.addAttribute("zamowienia", zamowienieService.getAll());
        return "adminZamowienieList";
    }

}
