package akcie;

import hlavnyBalik.Policko;
import obyvatelia.Ludia;
import obyvatelia.Rytieri;
import obyvatelia.Tvory;
import zemeplocha.Zemeplocha;

import javax.swing.*;

public class AkciaUtok implements Akcia {
    private final Policko mojePolicko;
    private final Policko druhePolicko;

    public AkciaUtok(Policko mojePolicko, Policko druhePolicko) {
        this.mojePolicko = mojePolicko;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Útok";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetUtocnikov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet utocnikov.") );
        Ludia ja = (Ludia) this.mojePolicko.getObyvatelia().orElseThrow();
        if (pocetUtocnikov < 0) {
            JOptionPane.showMessageDialog(null, "Nie som si isty, ako by si to chcel dosiahnut.");
        } else if (pocetUtocnikov > ja.getPopulacia()) {
            //tolko tvorov policko nema
            JOptionPane.showMessageDialog( null, "Nemas tolko rytierov.");
        } else {
            var napadnuti = this.druhePolicko.getObyvatelia().orElseThrow();

            if (pocetUtocnikov > napadnuti.getPopulacia()) {
                pocetUtocnikov = napadnuti.getPopulacia();
            }

            ja.zautoc(this.mojePolicko, this.druhePolicko, pocetUtocnikov);
        }
    }
}
