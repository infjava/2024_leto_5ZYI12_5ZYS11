package obyvatelia;

public class Rytieri extends Ludia {
    public Rytieri(int populacia) {
        super(populacia, TypObyvatela.RYTIERI);
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Rytieri(pocetTvorov);
    }

    @Override
    protected int vypocitajSiluUtoku(int pocetUtocnikov) {
        return pocetUtocnikov;
    }

    @Override
    protected void prijmiUtok(int silaUtoku) {
        this.upravPopulaciu(-silaUtoku);
    }
}
