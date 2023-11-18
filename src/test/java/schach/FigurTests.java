package schach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigurTests {

   private final Spieler spieler = new Spieler("Spieler1", "weiß");
   private final Figur figur = new Figur("TestFigur", 10, 0, spieler);
   private final Spielfeld spielfeld = new Spielfeld();

   @Test
    @DisplayName("Getter Methoden funktionieren")
    void testGetter() {
       assertEquals("Spieler1", figur.getSpieler().getName());
       assertEquals("TestFigur", figur.getName());
       assertEquals(10, figur.getWert());
       assertEquals(0, figur.getPosition());
   }

   @Test
   @DisplayName("Setter Mehtoden funktionieren")
    void testSetter(){
       figur.setPosition(5);
       assertEquals(5, figur.getPosition());
   }

   @Test
   @DisplayName("Methode getVonPlatz funktioniert")
   void testGetVonPlatz() {
      Platz vonPlatz = figur.getVonPlatz(spielfeld);
      assertEquals(vonPlatz, spielfeld.getPlaetze().get(0).get(0));
   }

   @Test
   @DisplayName("Methode getZuPlatz funktioniert")
   void testGetZuPlatz(){
      Platz zuPlatz = Figur.getZuPlatz(10, spielfeld);
      assertEquals(zuPlatz, spielfeld.getPlaetze().get(1).get(2));
   }
}
