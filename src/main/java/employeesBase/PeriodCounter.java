import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PeriodCounter {

    private LocalDate hireDate;
    private LocalDate currentDate;

    public PeriodCounter() {
        try{this.hireDate = LocalDate.parse("1995-01-1", DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
        this.currentDate = LocalDate.now();
    }

    public int count() {
        //NullPointerException
        return Period.between(hireDate, currentDate).getYears();
    }
}
