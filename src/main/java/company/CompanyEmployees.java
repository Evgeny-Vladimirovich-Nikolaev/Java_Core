import creator.Branches;

public class CompanyEmployees {

    public static void main(String[] args) {
        for(int i = 0; i < Branches.values().length; i++) {
            System.out.println(Branches.values()[i].getBranchNumber());
            System.out.println(Branches.values()[i].getBranch());
            System.out.println(Branches.values()[i].getCity());
        }
    }

}
