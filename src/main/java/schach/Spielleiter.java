package schach;

public class Spielleiter {
    private Spieler spieler1;
    private Spieler spieler2;
    private Spielfeld spielfeld;

    public Spielleiter(){
        this.spieler1 = new Spieler("weiss", "weiss");
        this.spieler2 = new Spieler("schwarz", "schwarz");
        this.spielfeld = new Spielfeld();
    }

    public Spielfeld getSpielfeld(){
        return spielfeld;
    }

    public void eingabe(String eingabe){
        Figur zuBewegendeFigur;
        Platz zuPlatz;

        try{
            int von = Integer.parseInt(eingabe.split(" ")[0]);
            int zu = Integer.parseInt(eingabe.split(" ")[1]);
            zuBewegendeFigur = spielfeld.getPlaetze().get(von / 8).get(von % 8).getAktuelleFigur();
            zuPlatz = spielfeld.getPlaetze().get(zu / 8).get(zu % 8);
        } catch (Exception e){
            System.out.println("Ungültige Eingabe");
            return;
        }

        zuBewegendeFigur.zug(zuPlatz, spielfeld);

    }




}
