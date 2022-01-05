import java.util.Objects;

public class BalancedHashContact extends Contact{

    private int hash;

    public BalancedHashContact(String[] fio,
                               long phoneNumber,
                               String typePhone,
                               String operator) {
        super(fio, phoneNumber, typePhone, operator);
        hash = (int)(phoneNumber / 10000000) * 31; //ключи берутся из первых 4 цифр номера - около 100 вариантов
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalancedHashContact cnt = (BalancedHashContact) o;
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
