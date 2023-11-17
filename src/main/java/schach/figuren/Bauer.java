package schach.figuren;

import schach.Figur;
import schach.Spielfeld;
import schach.Platz;

public class Bauer extends Figur {

    public Bauer(String name, int wert, int position, String farbe) {
        super(name, wert, position, farbe);
    }
    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        if (getZuPlatz(zuNummer, spielfeld).getBelegt()){
            schlagen(zuPlatz, spielfeld);
            return;
        }
        if (zuNummer == getPosition() + 8 && zuNummer <= 63 && !getZuPlatz(zuNummer, spielfeld).getBelegt()){
            move(zuPlatz, spielfeld);
            return;
        }
        System.out.println("Fehlerhafte Eingabe für Bauer, welcher von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte.");
    }
    public void schlagen(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        if ((zuNummer == getPosition() + 8 - 1 || zuNummer == getPosition() + 8 + 1) && zuNummer <= 63){
            move(zuPlatz, spielfeld);
            return;
            // Spielerscore hinzufügen
        }
        System.out.println("Fehlerhafte Eingabe für Bauer, welcher von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer() + " laufen wollte." );
    }
    public void move(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        System.out.println("Bauer bewegt von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer());
        Platz vonPlatz = getVonPlatz(spielfeld);
        zuPlatz.setAktuelleFigur(vonPlatz.getAktuelleFigur());
        zuPlatz.setBelegt(true);
        vonPlatz.setAktuelleFigur(new Figur("", 0, vonPlatz.getNummer(), ""));
        vonPlatz.setBelegt(false);

        setPosition(zuNummer);
    }



}
