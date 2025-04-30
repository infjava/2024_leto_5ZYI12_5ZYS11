import java.io.Serializable;

public class Student implements Serializable {
    private final String meno;
    private final String priezvisko;
    private final int rokNarodenia;

    public Student(String meno, String priezvisko, int rokNarodenia) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.rokNarodenia = rokNarodenia;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public int getRokNarodenia() {
        return this.rokNarodenia;
    }

    @Override
    public String toString() {
        return "Student{" +
                "meno='" + this.meno + '\'' +
                ", priezvisko='" + this.priezvisko + '\'' +
                ", rokNarodenia=" + this.rokNarodenia +
                '}';
    }
}
