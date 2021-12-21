import java.util.TreeMap;


public class PhoneBook {

    public static void main(String[] args) {
        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(901, "МТС");
        t.put(912, "МТС");
        t.put(918, "МТС");
        t.put(982, "МТС");
        t.put(983, "МТС");
        t.put(984, "МТС");
        System.out.println(t);
        System.out.println(t.ceilingEntry(918));
        String s = "901, 930, 932, 933, 938, 939, 958, 966, 977, 980, 989, 993, 995, 996";
        s = s.replace(", ", "\n");
        System.out.println(s);
        new ContactBuilder();
 }

}
