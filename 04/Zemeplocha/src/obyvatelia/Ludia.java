package obyvatelia;

public abstract class Ludia extends Tvory {
    public Ludia(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    protected abstract void prijmiUtok(int pocetUtocnikov);
}
