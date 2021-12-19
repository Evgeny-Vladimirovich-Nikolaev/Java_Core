import java.time.LocalDate;

public class Employee {

    private final int ID;
    private String lastName;
    private final String FIRST_NAME;
    private final String PATRONYMIC;
    private final LocalDate HIRE_DATE;

    public Employee(int id, String lastName, String firstName, String patronymic, LocalDate hireDate) {
        this.ID = id;
        this.lastName = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.HIRE_DATE = hireDate;
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

    public String getFIO() {
        StringBuilder sb = new StringBuilder(lastName);
        sb.append(" ");
        sb.append(FIRST_NAME);
        sb.append(" ");
        sb.append(PATRONYMIC);
        return sb.toString();
    }

    public LocalDate getHIRE_DATE() {
        return HIRE_DATE;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", PATRONYMIC='" + PATRONYMIC + '\'' +
                ", HIRE_DATE=" + HIRE_DATE +
                '}';
    }
}
