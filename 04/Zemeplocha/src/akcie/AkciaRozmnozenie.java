package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaRozmnozenie implements Akcia {
    private final Policko druhePolicko;
    private final int koeficientMagie;

    public AkciaRozmnozenie(Policko druhePolicko, int koeficientMagie) {
        this.druhePolicko = druhePolicko;
        this.koeficientMagie = koeficientMagie;
    }

    @Override
    public String getNazov() {
        return "Rozmnoženie";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var druhePolickoObyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();
        druhePolickoObyvatelia.rozmnoz(this.koeficientMagie);
    }
}
