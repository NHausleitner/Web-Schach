package schach;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    Spielfeld spielfeld = new Spielfeld();
    Spielleiter spielleiter = new Spielleiter();

    @GetMapping("/")
    public String startseite(Model model){
        model.addAttribute("spielfeld", spielfeld.getPlaetze());
        return "Startseite";
    }

    @PostMapping("/")
    public String durchEingabeBewegen(@RequestParam String eingabe, Model model){
        try{
            int von = Integer.parseInt(eingabe.split(" ")[0]);
            int zu = Integer.parseInt(eingabe.split(" ")[1]);

            Figur zuBewegendeFigur = spielfeld.getPlaetze().get(von / 8).get(von % 8).getAktuelleFigur();
            Platz zuPlatz = spielfeld.getPlaetze().get(zu / 8).get(zu % 8);

            zuBewegendeFigur.zug(zuPlatz, spielfeld, spielleiter);
        } catch (Exception e){
            System.out.println("Ungültige Eingabe");
        }
        // hier weitermachen
        //spielleiter.perform(eingabe);

        model.addAttribute("spielfeld", spielfeld.getPlaetze());
        return "Startseite";
    }
    
}
