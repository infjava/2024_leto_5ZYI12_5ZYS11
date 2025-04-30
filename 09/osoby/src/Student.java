import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Student {
    private final String meno;
    private final String priezvisko;
    private final long rokNarodenia;

    public Student(String meno, String priezvisko, long rokNarodenia) {
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

    public long getRokNarodenia() {
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

    public void ulozitDoSuboru(DataOutputStream zapisovac) throws IOException {
        zapisovac.writeUTF(this.meno);
        zapisovac.writeUTF(this.priezvisko);
        zapisovac.writeLong(this.rokNarodenia);
    }

    public static Student nacitatZoSuboru(DataInputStream citac, int verzia) throws IOException {
        var meno = citac.readUTF();
        var priezvisko = citac.readUTF();
        long rokNarodenia;
        if (verzia >= 2) {
            rokNarodenia = citac.readLong();
        } else {
            rokNarodenia = citac.readInt();
        }

        return new Student(meno, priezvisko, rokNarodenia);
    }
}
