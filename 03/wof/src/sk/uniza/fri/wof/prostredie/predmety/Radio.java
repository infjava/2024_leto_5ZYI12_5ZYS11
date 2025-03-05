package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Radio implements Predmet {
    private boolean maBaterky;

    public Radio() {
        this.maBaterky = false;
    }

    @Override
    public String getNazov() {
        return "radio";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (this.maBaterky) {
            System.out.println("Radio hra, lalala");
        } else {
            System.out.println("Radio nema baterky");
        }
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }

    public void vlozBaterky() {
        this.maBaterky = true;
    }
}
