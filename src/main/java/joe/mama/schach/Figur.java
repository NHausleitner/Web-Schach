package joe.mama.schach;

public class Figur {

    public Figur(String name, int wert, int position, String farbe) {
        this.name = name;
        this.wert = wert;
        this.position = position;
        this.farbe = farbe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private String name;
    private int wert;
    private int position;
    private String farbe;


}
