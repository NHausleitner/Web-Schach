package schach;

public class Spieler {
    private final String name;
    private final String farbe;
    private int punktestand;

    public Spieler(String name, String farbe){
        this.name = name;
        this.farbe = farbe;
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
