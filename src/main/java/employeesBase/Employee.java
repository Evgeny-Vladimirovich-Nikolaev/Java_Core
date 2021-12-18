public class Employee {

    private final int ID;
    private String lastName;
    private final String FIRST_NAME;
    private final String PATRONYMIC;
    private final String HIRE_DATE;

    public Employee(int ID, String lastName, String FIRST_NAME, String PATRONYMIC, String HIRE_DATE) {
        this.ID = ID;
        this.lastName = lastName;
        this.FIRST_NAME = FIRST_NAME;
        this.PATRONYMIC = PATRONYMIC;
        this.HIRE_DATE = HIRE_DATE;
    }

    public int getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getPATRONYMIC() {
        return PATRONYMIC;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }
}
