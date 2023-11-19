package schach.figuren;

import schach.*;

import java.util.HashSet;
import java.util.Set;

public class Koenigin extends Figur {

    public Koenigin(String name, int wert, int position, Spieler spieler) {
        super(name, wert, position, spieler);
    }

    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        Figur vonAktuelleFigur = getVonPlatz(spielfeld).getAktuelleFigur();
        int vonNummer = vonAktuelleFigur.getPosition();
        if (getZulaessigeNummern(vonNummer, spielfeld).contains(zuNummer)){
            if (zuPlatz.istBelegt() && farbenSindUnterschiedlich(spielfeld, zuNummer)){
                vonAktuelleFigur.getSpieler().punktestandErhoehen(vonAktuelleFigur.getWert());
                super.bewegen(zuPlatz, spielfeld);
                return;
            }
            if (!zuPlatz.istBelegt()){
                super.bewegen(zuPlatz, spielfeld);
                return;
            }
        }
        System.out.println("Fehlerhafte Eingabe für Königin, welche von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte.");
    }

    private boolean farbenSindUnterschiedlich(Spielfeld spielfeld, int zuNummer){
        return !getZuPlatz(zuNummer, spielfeld).getAktuelleFigur().getSpieler().getFarbe().equals(getVonPlatz(spielfeld).getAktuelleFigur().getSpieler().getFarbe());
    }

    private Set<Integer> getZulaessigeNummern(int startnummer, Spielfeld spielfeld) {
        Set<Integer> zulaessigeNummern = new HashSet<>();
        Set<Integer> belegteNummern = spielfeld.getAlleBelegtenNummern(super.getSpieler());

        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, -1, 0); // vertikal nach oben
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, 1, 0); // vertikal nach unten
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, 0, -1); // horizontal nach links
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, 0, 1); // horizontal nach rechts
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, -1, -1); // diagonal oben links
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, -1, 1); // diagonal oben rechts
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, 1, -1); // diagonal unten links
        check(belegteNummern, zulaessigeNummern, startnummer, spielfeld, 1, 1); // diagonal unten rechts

        return zulaessigeNummern;
    }

    private void check(Set<Integer> belegteNummern, Set<Integer> zulaessigeNummern, int startnummer, Spielfeld spielfeld, int reiheOffset, int spalteOffset) {
        int reihe = startnummer / 8;
        int spalte = startnummer % 8;

        for (int i = 1; reihe + i * reiheOffset >= 0 && reihe + i * reiheOffset < 8 && spalte + i * spalteOffset >= 0 && spalte + i * spalteOffset < 8; i++) {
            int nummer = (reihe + i * reiheOffset) * 8 + (spalte + i * spalteOffset);
            int reiheVonZiel = nummer / 8;
            int spalteVonZiel = nummer % 8;

            if (!belegteNummern.contains(nummer)) {
                zulaessigeNummern.add(nummer);
            } else if (!spielfeld.getPlaetze().get(reiheVonZiel).get(spalteVonZiel).getAktuelleFigur().getSpieler().getFarbe().equals(super.getSpieler().getFarbe())) {
                zulaessigeNummern.add(nummer);
                break;
            } else {
                break;
            }
        }
    }
}