import java.util.Objects;

public class DifferentHashContact extends Contact{

    private int hash;

    public DifferentHashContact(String[] fio,
                            long phoneNumber,
                            String typePhone,
                            String operator) {
        super(fio, phoneNumber, typePhone, operator);
        hash = (int)(phoneNumber - 10_000_000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DifferentHashContact cnt = (DifferentHashContact) o;
        return Objects.equals(phoneNumber, cnt.phoneNumber);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return  getFIO() + " "
                + numberToString() + " "
                + hash;
    }
}
