package schach;

public class Spieler {
    private final String name;
    private final String farbe;
    private boolean amZug;
    private int punktestand = 0;

    public Spieler(String name, String farbe){
        this.name = name;
        this.farbe = farbe;
        this.amZug = farbe.equals("weiss");
    }

    public String getName(){
        return name;
    }
    public void punktestandErhoehen(int wert){
        punktestand+=wert;
    }
    public int getPunktestand(){
        return punktestand;
    }
    public String getFarbe(){
        return farbe;
    }

}