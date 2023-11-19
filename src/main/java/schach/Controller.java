package schach;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    Spielleiter spielleiter = new Spielleiter();

    @GetMapping("/")
    public String startseite(Model model){
        model.addAttribute("spielfeld", spielleiter.getSpielfeld().getPlaetze());
        return "Startseite";
    }

    @PostMapping("/")
    public String durchEingabeBewegen(@RequestParam String eingabe, Model model){
        spielleiter.eingabe(eingabe);
        model.addAttribute("spielfeld", spielleiter.getSpielfeld().getPlaetze());
        return "Startseite";
    }
    
}