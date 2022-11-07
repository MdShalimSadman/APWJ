import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Student s=new Student();
        LocalDate l= LocalDate.of(1999,10, 5);
        AgeCalculator<Student> iObj=new AgeCalculator<Student>(s);
        iObj.calculate(l);

    }
}