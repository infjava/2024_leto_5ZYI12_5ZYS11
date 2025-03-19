package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Rytieri extends Ludia {
    public Rytieri(int populacia) {
        super(populacia, TypObyvatela.RYTIERI);
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

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Rytieri(pocetTvorov);
    }

    public void zautoc(Policko mojePolicko, Policko druhePolicko, int pocetUtocnikov) {
        var napadnuti = (Ludia)druhePolicko.getObyvatelia().orElseThrow();

        napadnuti.prijmiUtok(pocetUtocnikov);
        this.upravPopulaciu(-pocetUtocnikov);

        if (this.getPopulacia() <= 0) {
            mojePolicko.zruseniObyvatelia();
        }
        if (napadnuti.getPopulacia() <= 0) {
            druhePolicko.zruseniObyvatelia();
        }
    }

    @Override
    protected void prijmiUtok(int pocetUtocnikov) {
        this.upravPopulaciu(-pocetUtocnikov);
    }
}
