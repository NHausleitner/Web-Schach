package joe.mama.schach;

import joe.mama.schach.Figuren.*;

import java.util.List;

public class Platz {
    private int nummer;
    private boolean belegt;
    private Figur aktuelleFigur;
    private String feldfarbe;

    public Platz(boolean belegt, int nummer, String feldfarbe, Spielfeld spielfeld){
        this.belegt = belegt;
        this.nummer = nummer;
        this.feldfarbe = feldfarbe;
        this.aktuelleFigur = spielfeld.figurenInitialisieren(nummer);
    }



    public Figur getAktuelleFigur() {
        return this.aktuelleFigur;
    }
    public void setAktuelleFigur(Figur figur){
        this.aktuelleFigur = figur;
    }
    public boolean getBelegt() {
        return this.belegt;
    }
    public void setBelegt(boolean belegt) {
        this.belegt = belegt;
    }
    public int getNummer() {
        return this.nummer;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
    public String getFeldfarbe(){
        return this.feldfarbe;
    }
    public void setFeldfarbe(String feldfarbe){
        this.feldfarbe = feldfarbe;
    }

}
