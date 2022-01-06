import java.util.Objects;

public class EqualHashContact extends Contact{

    public EqualHashContact(String[] fio,
                            long phoneNumber,
                            String typePhone,
                            String operator) {
        super(fio, phoneNumber, typePhone, operator);
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
        return 31;
    }

    @Override
    public String toString() {
        return  getFIO() + " "
                + numberToString() + " "
                + hashCode();
    }
}
