package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.services.AutorService;

import java.util.List;

@Controller
@RequestMapping("/autorzy")
public class AutorController {
    @Autowired
    AutorService autorService;

    @GetMapping("/list")
    public String getAutorzy(Model model) {
        List<Autor> autorzyList = autorService.getAutorzy();
        model.addAttribute("autorzy", autorzyList);
        return "autorzylist";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/formadd")
    public String addAutor(Model model) {
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "addautorform";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/saveAutor")
    public ModelAndView saveAutor(@ModelAttribute("autor")Autor autor) {
        autorService.saveAutor(autor);
        return new ModelAndView("redirect:/admin/autorzy/list");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/updateAutorForm")
    public String updateKategoriaForm(@RequestParam("autorId")int id, Model model){
        Autor autor = autorService.getAutor(id);
        model.addAttribute("autor",autor);
        return "addautorform";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deleteAutorForm")
    public ModelAndView deleteKategoriaForm(@RequestParam("autorId")int id, Model model){
        autorService.deleteAutor(id);
        return new ModelAndView("redirect:/admin/autorzy/list");
    }

}
