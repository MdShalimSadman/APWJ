import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator<t extends Person>{
    t d;
    AgeCalculator(t d){
        this.d=d;
    }
    public void calculate(LocalDate dob){
        LocalDate currentDate= LocalDate.now();
        Period period=Period.between(dob,currentDate);
        int year= period.getYears();
        int month=period.getMonths();
        int day=period.getDays();
        System.out.println("Your age is "+day+" days "+month+" months "+ year+" years ");

    }
}
