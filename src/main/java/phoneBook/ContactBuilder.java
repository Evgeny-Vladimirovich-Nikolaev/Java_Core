package phoneBook;

import utils.NameCreator;
import utils.ResourcesReader;

import java.util.*;

public class ContactBuilder {

    protected static HashMap<Integer, String> operators;
    protected static List<Integer> codes;
    private static List<Contact> contactList;
    protected static int number = 7_654_321;

    protected ContactBuilder(int items) {
        operators = OperatorsList.getOperators();
        codes = OperatorsList.getCodes();
        contactList = new ArrayList<>();
        addContacts(items);
    }

    public List<Contact> getContacts() {
        return contactList;
    }

    void addContacts(int item) {
        for (int i = 0; i < item; i++) {
            contactList.add(create());
        }
    }

    protected Contact create() {
        String[] fio = NameCreator.createFIO();
        int code = codes.get(new Random().nextInt(codes.size()));
        long phoneNumber =
            8_000_000_00_00L
            + code * 1_000_00_00L
            + number++;
        String operator = operators.get(code);
        return new Contact(fio, phoneNumber, "мобильный", operator);
    }

}

class OperatorsList {

    private static String[][] files = new String[][]{
            {"beeline.txt", "Билайн"},
            {"megaFon.txt", "Мегафон"},
            {"mts.txt", "МТС"},
            {"rosTeleCom.txt", "Ростелеком"},
            {"tele2.txt", "Tele2"}
    };
    private static ArrayList<Integer> codes = new ArrayList<>();
    private static HashMap<Integer,  String> operators = new HashMap<>();

    static {
        fillCollections();
    }



    private OperatorsList() {}

    private static void fillCollections() {
        for (String[] arr : files) {
            ArrayList<String> currentOperatorCodes = ResourcesReader.readByLines(arr[0]);
            for (String currentCode : currentOperatorCodes) {
                Integer code;
                try {
                    code = Integer.parseInt(currentCode);
                    if (code != null && code > 899 && code < 1000) {
                        operators.put(code, arr[1]);
                        codes.add(code);
                    } else {
                        System.out.println(currentCode + " - неправильный формат кода");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(currentCode + " - неправильный формат кода");
                }
            }
        }
    }

    static HashMap<Integer,  String> getOperators() {
        return operators;
    }

    static ArrayList<Integer> getCodes() {
        return codes;
    }
}
