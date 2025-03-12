package akcie;

import hlavnyBalik.Policko;
import obyvatelia.Tvory;
import zemeplocha.Zemeplocha;

import javax.swing.*;

public class AkciaLov implements Akcia {
    private final Policko mojePolicko;
    private final Policko druhePolicko;

    public AkciaLov(Policko mojePolicko, Policko druhePolicko) {
        this.mojePolicko = mojePolicko;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Lov";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetTvorov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet lovcov, ktore idu na lov.") );
        Tvory ja = this.mojePolicko.getObyvatelia().orElseThrow();
        if (pocetTvorov < 0) {
            JOptionPane.showMessageDialog(null, "Nie som si isty, ako by si to chcel dosiahnut.");
        } else if (pocetTvorov > ja.getPopulacia()) {
            //tolko tvorov policko nema
            JOptionPane.showMessageDialog( null, "Nemas tolko lovcov.");
        } else {
            //uz naozaj presidlujeme, z povodneho policka odidu a druhemu policku sa nastavia ako obyvatel
            var loveni = this.druhePolicko.getObyvatelia().orElseThrow();
            loveni.upravPopulaciu(-pocetTvorov);
            //presidlili sa vsetci
            if (loveni.getPopulacia() <= 0) {
                this.druhePolicko.zruseniObyvatelia();
            }
        }
    }
}
