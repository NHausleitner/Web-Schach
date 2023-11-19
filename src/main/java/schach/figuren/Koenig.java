package schach.figuren;

import schach.*;

public class Koenig extends Figur {

    public Koenig(String name, int wert, int position, Spieler spieler) {
        super(name, wert, position, spieler);
    }

    @Override
    public void zug(Platz zuPlatz, Spielfeld spielfeld){
        int zuNummer = zuPlatz.getNummer();
    }
}
