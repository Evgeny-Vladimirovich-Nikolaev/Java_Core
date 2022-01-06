import java.util.Objects;

public class DifferentHashContact extends Contact{

    public DifferentHashContact(String[] fio,
                            long phoneNumber,
                            String typePhone,
                            String operator) {
        super(fio, phoneNumber, typePhone, operator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DifferentHashContact cnt = (DifferentHashContact) o;
        return Objects.equals(getPhoneNumber(), cnt.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return (int)(getPhoneNumber() - 8_900_000_0000L);
    }

    @Override
    public String toString() {
        return  getFIO() + " "
                + numberToString() + " "
                + hashCode();
    }
}
