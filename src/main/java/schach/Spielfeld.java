package schach;

import schach.figuren.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Spielfeld {
    private final List<List<Platz>> plaetze;
    Spieler weiss = new Spieler("Spieler weiss", "weiss");
    Spieler schwarz = new Spieler("Spieler schwarz", "schwarz");

    public Spielfeld(){
        this.plaetze = plaetzeGenerieren();
    }

    private List<List<Platz>> plaetzeGenerieren() {
        AtomicInteger counter = new AtomicInteger(1);

        return IntStream.rangeClosed(0, 63)
                .boxed()
                .collect(Collectors.groupingBy(nummer -> nummer / 8))
                .values()
                .stream()
                .map(subList -> subList.stream()
                        .map(nummer -> new Platz(15 >= nummer || nummer >= 48, nummer, farbeEntscheiden(counter.getAndIncrement()), this))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

    }

    private String farbeEntscheiden(int counter) {
        return counter % 2 == 0 ? "schwarz" : "weiss";
    }

    public List<List<Platz>> getPlaetze(){
        return this.plaetze;
    }

    public Figur figurenInitialisieren(int nummer) {
        if (nummer >= 8 && nummer <= 15){
            return new Bauer("Bauer", 1, nummer, weiss);
        } else if (nummer >= 48 && nummer <= 55) {
            return new Bauer("Bauer", 1, nummer, schwarz);
        } else if (List.of(0, 7).contains(nummer)){
            return new Turm("Turm", 5, nummer, weiss);
        } else if (List.of(56, 63).contains(nummer)) {
            return new Turm("Turm", 5, nummer, schwarz);
        } else if (List.of(1, 6).contains(nummer)){
            return new Pferd("Pferd", 3, nummer, weiss);
        } else if (List.of(57, 62).contains(nummer)) {
            return new Pferd("Pferd", 3, nummer, schwarz);
        } else if (List.of(2, 5).contains(nummer)){
            return new Springer("Läufer", 3, nummer, weiss);
        } else if (List.of(58, 61).contains(nummer)) {
            return new Springer("Läufer", 3, nummer, schwarz);
        } else if (nummer == 3){
            return new Koenig("König", 0, nummer, weiss);
        } else if (nummer == 59) {
            return new Koenig("König", 0, nummer, schwarz);
        } else if (nummer == 4) {
            return new Koenigin("Königin", 9, nummer, weiss);
        } else if (nummer == 60) {
            return new Koenigin("Königin", 9, nummer, schwarz);
        } else {
            return new Figur("", 0, nummer, new Spieler("dummy", ""));
        }
    }

    public Set<Integer> getAlleBelegtenNummern(Spieler spieler){
        Set<Integer> alleBelegtenNummern = new HashSet<>();
        plaetze.stream()
                .flatMap(List::stream)
                .filter(Platz::istBelegt)
                .forEach(platz -> alleBelegtenNummern.add(platz.getNummer()));
        return alleBelegtenNummern;
    }

}