package schach;

public class Platz {
    private final int nummer;
    private boolean belegt;
    private Figur aktuelleFigur;
    private final String feldfarbe;

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
    public boolean istBelegt() {
        return this.belegt;
    }
    public void setBelegt(boolean belegt) {
        this.belegt = belegt;
    }
    public int getNummer() {
        return this.nummer;
    }

}
