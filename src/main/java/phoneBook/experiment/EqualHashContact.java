import java.util.Objects;

public class EqualHashContact extends Contact{

    private int hash;

    public EqualHashContact(String[] fio,
                            long phoneNumber,
                            String typePhone,
                            String operator) {
        super(fio, phoneNumber, typePhone, operator);

        hash = 31;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualHashContact cnt = (EqualHashContact) o;
        return Objects.equals(getPhoneNumber(), cnt.getPhoneNumber());
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
