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

    public void zug(Platz zuPlatz, Spielfeld spielfeld){
    }

    public void bewegen(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
        System.out.println(getVonPlatz(spielfeld).getAktuelleFigur().getName() +  " bewegt von " + getVonPlatz(spielfeld).getNummer() + " zu " + getZuPlatz(zuNummer, spielfeld).getNummer());
        Platz vonPlatz = getVonPlatz(spielfeld);
        zuPlatz.setAktuelleFigur(vonPlatz.getAktuelleFigur());
        zuPlatz.setBelegt(true);
        vonPlatz.setAktuelleFigur(new Figur("", 0, vonPlatz.getNummer(), new Spieler("dummy", "")));
        vonPlatz.setBelegt(false);

        setPosition(zuNummer);
    }

    public Platz getVonPlatz(Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(position / 8).get(position % 8);
    }

    public static Platz getZuPlatz(int zu, Spielfeld spielfeld) {
        return spielfeld.getPlaetze().get(zu / 8).get(zu % 8);
    }

}