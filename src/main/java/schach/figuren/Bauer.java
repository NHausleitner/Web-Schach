package schach.figuren;

import schach.*;

import java.util.HashSet;
import java.util.Set;

public class Bauer extends Figur {

    public Bauer(String name, int wert, int position, Spieler spieler) {
        super(name, wert, position, spieler);
    }

    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld, Spielleiter spielleiter){
        int zuNummer = zuPlatz.getNummer();
        Figur vonAktuelleFigur = getVonPlatz(spielfeld).getAktuelleFigur();
        if (zuNummer >= 0 && zuNummer <= 63){
            if (zuPlatz.istBelegt() && !getZuPlatz(zuNummer, spielfeld).getAktuelleFigur().getSpieler().getFarbe().equals(getVonPlatz(spielfeld).getAktuelleFigur().getSpieler().getFarbe())){
                vonAktuelleFigur.getSpieler().punktestandErhoehen(vonAktuelleFigur.getWert());
                schlagen(zuPlatz, spielfeld);
                return;
            }
            if (!getZuPlatz(zuNummer, spielfeld).istBelegt() && zuNummer == getPosition() + 8){
                super.bewegen(zuPlatz, spielfeld);
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
            super.bewegen(zuPlatz, spielfeld);
            return;
            // Spielerscore hinzufügen
        }
        System.out.println("Fehlerhafte Eingabe für Bauer, welcher von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte." );
    }




}
