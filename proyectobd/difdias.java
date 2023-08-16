
package proyectobd;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;


public class difdias {
    public static void main(String[] args) {


    String  requestDate = "2003-01-28";
    LocalDate myDate = LocalDate.parse(requestDate);

    LocalDate currentDate = LocalDate.now();

    long numberOFDays = DAYS.between(myDate, currentDate);

    System.out.println(String.format("The diff of days is %d",numberOFDays));

}
}
