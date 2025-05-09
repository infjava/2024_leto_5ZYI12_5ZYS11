package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public abstract class Ludia extends Tvory {
    public Ludia(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        ArrayList<Akcia> akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var cieloviObyvatelia = druhePolicko.getObyvatelia();
        if (cieloviObyvatelia.isPresent() && mojePolicko != druhePolicko && (cieloviObyvatelia.get() instanceof Ludia)) {
            akcie.add(new AkciaUtok(mojePolicko, druhePolicko));
        }

        return akcie;
    }

    public void zautoc(Policko mojePolicko, Policko druhePolicko, int pocetUtocnikov) {
        var napadnuti = (Ludia)druhePolicko.getObyvatelia().orElseThrow();

        napadnuti.prijmiUtok(this.vypocitajSiluUtoku(pocetUtocnikov));
        this.prijmiUtok(napadnuti.vypocitajSiluUtoku(pocetUtocnikov));

        if (this.getPopulacia() <= 0) {
            mojePolicko.zruseniObyvatelia();
        }
        if (napadnuti.getPopulacia() <= 0) {
            druhePolicko.zruseniObyvatelia();
        }
    }

    protected abstract int vypocitajSiluUtoku(int pocetUtocnikov);

    protected abstract void prijmiUtok(int silaUtoku);
}
