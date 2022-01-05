import java.util.Random;

public class BalancedContactBuilder extends ContactBuilder{
    BalancedContactBuilder(int items) {
        super(items);
    }

    @Override
    protected Contact create() {
        String[] fio = NameCreator.createFIO();
        int code = codes.get(new Random().nextInt(codes.size()));
        long phoneNumber =
                8_000_000_00_00L
                        + code * 1_000_00_00L
                        + number++;
        String operator = operators.get(code);
        return new BalancedHashContact(fio, phoneNumber, "мобильный", operator);
    }
}
