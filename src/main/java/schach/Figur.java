package schach;

public class Figur {

    private final String name;
    private final int wert;
    private int position;
    private final Spieler spieler;


    public Figur(String name, int wert, int position, Spieler spieler) {
        this.name = name;
        this.wert = wert;
        this.position = position;
        this.spieler = spieler;
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public String getName() {
        return name;
    }

    public int getWert() {
        return wert;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void zug(Platz zuPlatz, Spielfeld spielfeld, Spielleiter spielleiter){
    }

    public Platz getVonPlatz(Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(position / 8).get(position % 8);
    }

    public static Platz getZuPlatz(int zu, Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(zu / 8).get(zu % 8);
    }

}