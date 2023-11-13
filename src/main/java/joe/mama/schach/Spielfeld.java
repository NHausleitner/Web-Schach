package joe.mama.schach;

import joe.mama.schach.Figuren.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Spielfeld {
    private final List<List<Platz>> plaetze;

    public Spielfeld(){
        this.plaetze = plaetzeGenerieren();
    }
    private List<List<Platz>> plaetzeGenerieren() {
        AtomicInteger counter = new AtomicInteger(1);

        return IntStream.rangeClosed(1, 64)
                .boxed()
                .collect(Collectors.groupingBy(nummer -> (nummer - 1) / 8))
                .values()
                .stream()
                .map(subList -> subList.stream()
                        .map(nummer -> new Platz(16 >= nummer || nummer >= 48, nummer, farbeEntscheiden(counter.getAndIncrement()), this))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

    }

    private String farbeEntscheiden(int counter) {
        return counter % 2 == 0 ? "schwarz" : "weiß";
    }

    public List<List<Platz>> getPlaetze(){
        return this.plaetze;
    }

    public Figur figurenInitialisieren(int nummer) {
        if (nummer >= 9 && nummer <= 16){
            return new Bauer("Bauer", 1, nummer, "weiß");
        } else if (nummer >= 49 && nummer <= 56) {
            return new Bauer("Bauer", 1, nummer, "schwarz");
        } else if (List.of(1, 8).contains(nummer)){
            return new Turm("Turm", 5, nummer, "weiß");
        } else if (List.of(57, 64).contains(nummer)) {
            return new Turm("Turm", 5, nummer, "schwarz");
        } else if (List.of(2, 7).contains(nummer)){
            return new Pferd("Pferd", 3, nummer, "weiß");
        } else if (List.of(58, 63).contains(nummer)) {
            return new Pferd("Pferd", 3, nummer, "schwarz");
        } else if (List.of(3, 6).contains(nummer)){
            return new Läufer("Läufer", 3, nummer, "weiß");
        } else if (List.of(59, 62).contains(nummer)) {
            return new Läufer("Läufer", 3, nummer, "schwarz");
        } else if (nummer == 4){
            return new König("König", 0, nummer, "weiß");
        } else if (nummer == 60) {
            return new König("König", 0, nummer, "schwarz");
        } else if (nummer == 5) {
            return new Königin("Königin", 9, nummer, "weiß");
        } else if (nummer == 61) {
            return new Königin("Königin", 9, nummer, "schwarz");
        } else {
            return new Figur("", 0, nummer, "");
        }

    }

}
