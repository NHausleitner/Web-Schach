package schach;

public class Spielleiter {
    private String farbeAmZug;

    public Spielleiter(){
        this.farbeAmZug = "weiß";
    }

    public void gezogen(){
        farbeAmZug = farbeAmZug.equals("weiß") ? "schwarz" : "weiß";
    }

}
