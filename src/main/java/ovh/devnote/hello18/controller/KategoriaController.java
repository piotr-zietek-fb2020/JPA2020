package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.services.KategoriaService;

import java.util.List;

@Controller
@RequestMapping("/kategorie")
public class KategoriaController {
    @Autowired
    KategoriaService kategoriaService;

    @GetMapping("/list")
    public String getKategorie(Model model) {
        List<Kategoria> kategoriaList = kategoriaService.getKategorie();
        model.addAttribute("kategorie", kategoriaList);
        return "kategorialist";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/formadd")
    public String addKategoria(Model model) {
        Kategoria kategoria = new Kategoria();
        model.addAttribute("kategoria", kategoria);
        return "addkategoriaform";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/saveKategoria")
    public ModelAndView saveKategoria(@ModelAttribute("kategoria")Kategoria kategoria) {
        kategoriaService.saveKategoria(kategoria);
        return new ModelAndView("redirect:/admin/kategorie/list");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/updateKategoriaForm")
    public String updateKategoriaForm(@RequestParam("kategoriaId")int id, Model model){
        Kategoria kategoria = kategoriaService.getKategoria(id);
        model.addAttribute("kategoria",kategoria);
        return "addkategoriaform";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deleteKategoriaForm")
    public ModelAndView deleteKategoriaForm(@RequestParam("kategoriaId")int id, Model model){
        kategoriaService.deleteKategoria(id);
        return new ModelAndView("redirect:/admin/kategorie/list");
    }

}
