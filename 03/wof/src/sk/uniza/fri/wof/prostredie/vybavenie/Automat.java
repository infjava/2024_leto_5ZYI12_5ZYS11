package sk.uniza.fri.wof.prostredie.vybavenie;

public class Automat implements Vybavenie {
    @Override
    public String getNazov() {
        return "automat";
    }

    @Override
    public String getPopis() {
        return "výpredaj bagiet a minerálok";
    }
}
