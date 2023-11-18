package schach.figuren;

import schach.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bauer extends Figur {

    public Bauer(String name, int wert, int position, Spieler spieler) {
        super(name, wert, position, spieler);
    }

    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld, Spielleiter spielleiter){
        List<Integer> startpositionen = List.of(8, 9, 10, 11, 12, 13, 14, 15);
        int vonNummer = getVonPlatz(spielfeld).getNummer();
        int zuNummer = zuPlatz.getNummer();
        Figur vonAktuelleFigur = getVonPlatz(spielfeld).getAktuelleFigur();
        if (zuNummer >= 0 && zuNummer <= 63){
            if (zuPlatz.istBelegt() && !getZuPlatz(zuNummer, spielfeld).getAktuelleFigur().getSpieler().getFarbe().equals(getVonPlatz(spielfeld).getAktuelleFigur().getSpieler().getFarbe())){
                vonAktuelleFigur.getSpieler().punktestandErhoehen(vonAktuelleFigur.getWert());
                schlagen(zuPlatz, spielfeld);
                return;
            }
            if (!getZuPlatz(zuNummer, spielfeld).istBelegt() && zuNummer == getPosition() + 8){
                bewegen(zuPlatz, spielfeld);
                return;
            }
            if(!getZuPlatz(zuNummer, spielfeld).istBelegt() && startpositionen.contains(vonNummer)){
                bewegen(zuPlatz, spielfeld);
                return;
            }
        }
        System.out.println("Fehlerhafte Eingabe für Bauer, welcher von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte.");
    }

    private Set<Integer> getMoeglicheNummern(int startnummer, Spielfeld spielfeld, Spielleiter spielleiter){
        Set<Integer> moeglicheNummern = new HashSet<>();
        return moeglicheNummern;
    }

    private void schlagen(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        if ((zuNummer == getPosition() + 8 - 1 || zuNummer == getPosition() + 8 + 1) && zuNummer <= 63){
            bewegen(zuPlatz, spielfeld);
            return;
            // Spielerscore hinzufügen
        }
        System.out.println("Fehlerhafte Eingabe für Bauer, welcher von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte." );
    }

    private void bewegen(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        System.out.println("Bauer bewegt von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer());
        Platz vonPlatz = getVonPlatz(spielfeld);
        zuPlatz.setAktuelleFigur(vonPlatz.getAktuelleFigur());
        zuPlatz.setBelegt(true);
        vonPlatz.setAktuelleFigur(new Figur("", 0, vonPlatz.getNummer(), new Spieler("dummy", "")));
        vonPlatz.setBelegt(false);

        setPosition(zuNummer);
    }



}
