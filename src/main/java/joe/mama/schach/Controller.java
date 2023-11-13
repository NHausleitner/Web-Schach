package joe.mama.schach;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String startseite(Model model, Spielfeld spielfeld){
        model.addAttribute("spielfeld", spielfeld.getPlaetze());
        return "Startseite";
    }

    @PostMapping("/")
    public String eingabe(@RequestParam String eingabe, Model model, Spielfeld spielfeld){
        model.addAttribute("spielfeld", spielfeld.getPlaetze());
        return "Startseite";
    }
    
}
