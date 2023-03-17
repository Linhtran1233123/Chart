
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
        int choice=1;
        while (choice!=0) {
            System.out.println("%nEnter your regex: ");
            Pattern pattern =
                    Pattern.compile("(\\d|[0-2][0-9]|3[0-1])[-|/](\\d|0[1-9]|1[1-2])[-|/]\\d{4,}\\s+(\\d|([0-1][0-9])|(2[0-3])):(\\d|([0-5][0-9])):(\\d|([0-5][0-9]))");
            System.out.println("Enter input string to search: ");
            Scanner s = new Scanner(System.in);
            String date= s.nextLine();
            Matcher matcher =
                    pattern.matcher(date);

            boolean found = false;
            if (matcher.matches()) {
                 s=new Scanner(date);
                s.findInLine("(\\d+)[-/](\\d+)[-/](\\d+)\\s+(\\d+):(\\d+):(\\d+)");
                MatchResult result = s.match();
                int day=Integer.parseInt(result.group(1));
                int month=Integer.parseInt(result.group(2));
                int year=Integer.parseInt(result.group(3));
                int hrs=Integer.parseInt(result.group(4));
                int min=Integer.parseInt(result.group(4));
                int sec=Integer.parseInt(result.group(6));
                s.close();
                LocalDateTime date1= LocalDateTime.of(year, Month.of(month),day,hrs,min,sec);
                s.close();
                System.out.println(date1);
                System.out.println("true");
                found = true;
            }
            if(!found){
                System.out.println("No match found.%n");
            }
            choice=Integer.parseInt(new Scanner(System.in).nextLine());
        }
    }
}