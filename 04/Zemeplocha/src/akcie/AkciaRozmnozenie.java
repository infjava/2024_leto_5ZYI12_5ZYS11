package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaRozmnozenie implements Akcia {
    public AkciaRozmnozenie(Policko druhePolicko, int koeficientMagie) {
    }

    @Override
    public String getNazov() {
        return "Rozmnoženie";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {

    }
}
