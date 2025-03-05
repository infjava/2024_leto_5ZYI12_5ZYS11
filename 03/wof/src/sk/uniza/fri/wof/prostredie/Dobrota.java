package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.predmety.Pouzitelny;
import sk.uniza.fri.wof.prostredie.predmety.Predmet;
import sk.uniza.fri.wof.zaklad.Hrac;

public class Dobrota implements Predmet, Pouzitelny {
    private final String nazov;
    private final String nazovAkuzativ;
    private int pocetPouziti;

    public Dobrota(String nazov, String nazovAkuzativ, int pocetPouziti) {
        this.nazov = nazov;
        this.nazovAkuzativ = nazovAkuzativ;
        this.pocetPouziti = pocetPouziti;
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.pocetPouziti--;
        System.out.format("Dal si si %s%n", this.nazovAkuzativ);
        if (this.pocetPouziti <= 0) {
            hrac.odstranPredmet(this);
            System.out.printf("%s si zlikvidoval%n", this.nazovAkuzativ);
        }
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }
}
