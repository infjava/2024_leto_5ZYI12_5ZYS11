package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Baterky implements Predmet, Pouzitelny {
    @Override
    public String getNazov() {
        return "baterky";
    }

    @Override
    public void pouzi(Hrac hrac) {
        var radio = hrac.najdiPredmet("radio");
        if (radio.isPresent()) {
            ((Radio) radio.get()).vlozBaterky();
            hrac.odstranPredmet(this);
            System.out.println("Vlozil si baterky do radia");
        } else {
            System.out.println("Baterky nevies pouzit");
        }
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }
}
