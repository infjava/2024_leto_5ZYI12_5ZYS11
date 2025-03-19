package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Rytieri extends Tvory {
    public Rytieri(int populacia) {
        super(populacia, TypObyvatela.RYTIERI);
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Rytieri(pocetTvorov);
    }
}
