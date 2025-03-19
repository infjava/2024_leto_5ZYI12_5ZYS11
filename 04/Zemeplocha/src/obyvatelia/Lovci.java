package obyvatelia;

import akcie.Akcia;
import akcie.AkciaLov;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Lovci extends Ludia {
    public Lovci(int populacia) {
        super(populacia, TypObyvatela.LOVCI);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var druhePolickoObyvatelia = druhePolicko.getObyvatelia();
        if (druhePolickoObyvatelia.isPresent() && druhePolickoObyvatelia.get() instanceof Zver) {
            akcie.add(new AkciaLov(mojePolicko, druhePolicko));
        }

        return akcie;
    }

    @Override
    protected int vypocitajSiluUtoku(int pocetUtocnikov) {
        return pocetUtocnikov / 2;
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Lovci(pocetTvorov);
    }

    @Override
    protected void prijmiUtok(int silaUtoku) {
        this.upravPopulaciu(-2 * silaUtoku);
    }
}
