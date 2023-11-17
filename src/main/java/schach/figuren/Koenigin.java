package schach.figuren;

import schach.*;

import java.util.HashSet;
import java.util.Set;

public class Koenigin extends Figur {

    public Koenigin(String name, int wert, int position, Spieler spieler) {
        super(name, wert, position, spieler);
    }


    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld, Spielleiter spielleiter){
        int zuNummer = zuPlatz.getNummer();
        Figur vonAktuelleFigur = getVonPlatz(spielfeld).getAktuelleFigur();
        if (getMoeglicheNummern(zuNummer, spielfeld).contains(zuNummer)){
            if (zuPlatz.istBelegt() && farbenSindUnterschiedlich(spielfeld, zuNummer)){
                vonAktuelleFigur.getSpieler().punktestandErhoehen(vonAktuelleFigur.getWert());
                bewegen(zuPlatz, spielfeld);
                return;
            }
            if (!zuPlatz.istBelegt()){
                bewegen(zuPlatz, spielfeld);
                return;
            }
        }
        System.out.println("Fehlerhafte Eingabe für Königin, welche von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte.");
    }

    private boolean farbenSindUnterschiedlich(Spielfeld spielfeld, int zuNummer){
        return !getZuPlatz(zuNummer, spielfeld).getAktuelleFigur().getSpieler().getFarbe().equals(getVonPlatz(spielfeld).getAktuelleFigur().getSpieler().getFarbe());
    }

    private Set<Integer> getMoeglicheNummern(int startnummer, Spielfeld spielfeld){
        Set<Integer> moeglicheNummern = new HashSet<>();
        Set<Integer> alleBelegtenNummern = spielfeld.getAlleBelegtenNummern();
        int reihe = startnummer / 8;
        int spalte = startnummer % 8;

        // vertikal nach oben
        for (int i = 1; i <= reihe; i++){
            int nummer = startnummer - (8 * i);
            if (!alleBelegtenNummern.contains(nummer)){
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }

        // vertikal nach unten
        for (int i = 1; i <= 7 - reihe; i++){
            int nummer = startnummer + (8 * i);
            if (!alleBelegtenNummern.contains(nummer)){
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }

        // horizontal nach links
        for (int i = 1; i <= spalte; i++){
            int nummer = startnummer - i;
            if (!alleBelegtenNummern.contains(nummer)){
                moeglicheNummern.add(startnummer - spalte + i);
            } else {
                break;
            }
        }

        // horizontal nach rechts
        for (int i = 1; i <= 7 - spalte; i++){
            int nummer = startnummer + i;
            if (!alleBelegtenNummern.contains(nummer)){
                moeglicheNummern.add(startnummer - spalte + i);
            } else {
                break;
            }
        }

        // diagonal oben links
        for (int i = 1; reihe - i >= 0 && spalte - i >= 0; i++) {
            int nummer = (reihe - i) * 8 + (spalte - i);
            if (!alleBelegtenNummern.contains(nummer)) {
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }

        // diagonal oben rechts
        for (int i = 1; reihe - i >= 0 && spalte + i < 8; i++) {
            int nummer = (reihe - i) * 8 + (spalte + i);
            if (!alleBelegtenNummern.contains(nummer)) {
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }

        // diagonal unten links
        for (int i = 1; reihe + i < 8 && spalte - i >= 0; i++) {
            int nummer = (reihe + i) * 8 + (spalte - i);
            if (!alleBelegtenNummern.contains(nummer)) {
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }

        // diagonal unten rechts
        for (int i = 1; reihe + i < 8 && spalte + i < 8; i++) {
            int nummer = (reihe + i) * 8 + (spalte + i);
            if (!alleBelegtenNummern.contains(nummer)) {
                moeglicheNummern.add(nummer);
            } else {
                break;
            }
        }
        return moeglicheNummern;
    }

    private void bewegen(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        System.out.println("Königin bewegt von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer());
        Platz vonPlatz = getVonPlatz(spielfeld);
        zuPlatz.setAktuelleFigur(vonPlatz.getAktuelleFigur());
        zuPlatz.setBelegt(true);
        vonPlatz.setAktuelleFigur(new Figur("", 0, vonPlatz.getNummer(), new Spieler("dummy", "")));
        vonPlatz.setBelegt(false);

        setPosition(zuNummer);
    }
}