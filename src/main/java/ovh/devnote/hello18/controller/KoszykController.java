package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ovh.devnote.hello18.component.Koszyk;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.entity.Zamowienie;
import ovh.devnote.hello18.entity.ZamowienieSzczegoly;
import ovh.devnote.hello18.services.BookService;
import ovh.devnote.hello18.services.ZamowienieService;
import ovh.devnote.hello18.services.ZamowienieSzczegolyService;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.round;

@Controller
@RequestMapping("/koszyk")
public class KoszykController {
    @Autowired
    BookService bookService;
    @Autowired
    ZamowienieService zamowienieService;
    @Autowired
    ZamowienieSzczegolyService zamowienieSzczegolyService;

    @GetMapping("/")
    public String getKoszyk(HttpSession session, Model model) {
        String msg = "";
        float razem = 0;
        Koszyk koszyk = null;
        if (session.getAttribute("koszyk") == null) {
            msg = "Twoj koszyk jest pusty";
        } else {
            koszyk = (Koszyk)session.getAttribute("koszyk");
            for(Ksiazka k : koszyk.getKsiazki()) {
                razem += k.getCena();
            }
            msg = null;
        }
        model.addAttribute("koszyk", koszyk);
        model.addAttribute("msg", msg);
        model.addAttribute("razem", razem);
        return "koszyk";
    }

    @GetMapping("/dodaj")
    public String dodajDoKoszyka(@RequestParam("id") int id, HttpSession session, Model model) {
        Koszyk koszyk;
        if (session.getAttribute("koszyk") == null) {
            koszyk = new Koszyk();
        } else {
            koszyk = (Koszyk) session.getAttribute("koszyk");
        }
            Ksiazka ksiazka = bookService.getBook(id);
            koszyk.dodajKsiazke(ksiazka);
            session.setAttribute("koszyk", koszyk);
        return "redirect:/koszyk/";
    }

    @GetMapping("/usun")
    public String usunZKoszyka(@RequestParam("id") int id, HttpSession session, Model model) {
        Koszyk koszyk = (Koszyk) session.getAttribute("koszyk");
        koszyk.usunKsiazke(id);
        session.setAttribute("koszyk", koszyk);
        return "redirect:/koszyk/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/zloz-zamowienie")
    public String dodajZamoienie(HttpSession session) {
        Koszyk koszyk;
        float razem = 0;
        if (session.getAttribute("koszyk") == null) {
            return "redirect:/";
        } else {
            koszyk = (Koszyk) session.getAttribute("koszyk");
            Zamowienie zamowienie = new Zamowienie();
            List<ZamowienieSzczegoly> szczegoly = new ArrayList<>();
            ZamowienieSzczegoly zamowienieSzczegoly;
            for(Ksiazka k : koszyk.getKsiazki()) {
                razem += k.getCena();
                zamowienieSzczegoly = new ZamowienieSzczegoly();
                zamowienieSzczegoly.setKsiazka(k);
                zamowienieSzczegoly.setZamowienie(zamowienie);
                szczegoly.add(zamowienieSzczegoly);
            }
            zamowienie.setKwota(razem);
            zamowienie.setData(new Date(Calendar.getInstance().getTime().getTime()));
            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = securityContext.getAuthentication();
            String userName = null;
            if (authentication != null) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                userName = userDetails.getUsername();
            }
            zamowienie.setUsername(userName);
            zamowienie.setZamowienieSzczegolyList(szczegoly);
            zamowienieService.save(zamowienie);
            session.setAttribute("koszyk", null);
        }
        return "afterZamowienie";
    }

}
