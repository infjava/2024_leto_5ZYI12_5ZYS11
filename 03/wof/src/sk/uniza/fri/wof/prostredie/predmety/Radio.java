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

    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }

    @Override
    public void hracSaPohol() {
        if (this.maBaterky) {
            System.out.println("Radio hra, lalala");
        }
    }

    public void vlozBaterky() {
        this.maBaterky = true;
    }
}
