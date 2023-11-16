package joe.mama.schach;

public class Figur {

    private final String name;
    private final int wert;
    private int position;
    private final String farbe;


    public Figur(String name, int wert, int position, String farbe) {
        this.name = name;
        this.wert = wert;
        this.position = position;
        this.farbe = farbe;
    }

    public String getFarbe() {
        return farbe;
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

    public void zug(Platz zu, Spielfeld spielfeld){
        Platz zuPlatz = getZuPlatz(zu.getNummer(), spielfeld);
        Platz vonPlatz = getVonPlatz(spielfeld);
        zuPlatz.setAktuelleFigur(vonPlatz.getAktuelleFigur());
        zuPlatz.setBelegt(true);
        vonPlatz.setAktuelleFigur(new Figur("", 0, vonPlatz.getNummer(), ""));
        vonPlatz.setBelegt(false);

        position = zu.getNummer();
    }

    public Platz getVonPlatz(Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(position / 8).get(position % 8);
    }

    public static Platz getZuPlatz(int zu, Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(zu / 8).get(zu % 8);
    }


}
