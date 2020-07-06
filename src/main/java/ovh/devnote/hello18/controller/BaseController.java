package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.entity.Subskrybcja;
import ovh.devnote.hello18.entity.Wiadomosc;
import ovh.devnote.hello18.entity.Zamowienie;
import ovh.devnote.hello18.services.SubskrybcjaService;
import ovh.devnote.hello18.services.WiadomoscService;
import ovh.devnote.hello18.services.ZamowienieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BaseController {
    @Autowired
    WiadomoscService wiadomoscService;
    @Autowired
    SubskrybcjaService subskrybcjaService;
    @Autowired
    ZamowienieService zamowienieService;


    @RequestMapping("/")
    public String index() {
        return "index";
    }

/*    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)

    public String adminPage(ModelMap model) {
        model.addAttribute("message", "Admin page...");
        return "admin";
    }*/

/*    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("message", "User page...");
        return "user";
    }*/

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }


    @GetMapping("/kontakt")
    public String dodajWiadomosc(HttpServletRequest request, Model model) {
        String imie = request.getParameter(("imie_zapytania"));
        String email = request.getParameter(("email_zapytania"));
        String temat = request.getParameter(("temat_zapytania"));
        String wiadomosc = request.getParameter(("wiadomosc_zapytania"));
        Wiadomosc w = new Wiadomosc(imie, email, temat, wiadomosc);
        wiadomoscService.saveWiadmosc(w);
        return "redirect:/";
    }

    @GetMapping("/subskrybcja")
    public String dodajSubskrybcje(HttpServletRequest request, Model model) {
        String email = request.getParameter(("adres_email_subskrybcji"));
        Subskrybcja subskrybcja = new Subskrybcja(email);
        subskrybcjaService.save(subskrybcja);
        return "redirect:/";
    }

    @GetMapping("/zamowienia")
    public String getAllZamowienia(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userName = userDetails.getUsername();
        }
        String msg;
        List<Zamowienie> zamowienia = zamowienieService.getAllForUser(userName);
        if (zamowienia.size() == 0) {
            msg = "Jeszcze nie zlozyles zadnego zamowienia";
        } else {
            msg = null;
        }
        model.addAttribute("zamowienia", zamowienia);
        model.addAttribute("msg", msg);
        return "zamowienia";
    }

}
