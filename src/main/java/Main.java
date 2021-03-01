import java.time.MonthDay;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter a middle initial");
        String middleInitial = scanner.nextLine();
        System.out.println("Enter a last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter the last two digits of your birth year.");
        int birthYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your birth month.");
        int birthMonth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the day of your birth.");
        int birthDate = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your gender (M or F)");
        char genderCode = scanner.nextLine().charAt(0);
        int overflow = 0;

        DriversLicense dl = new DriversLicense();
        LastNameUtility lnu = new LastNameUtility();
        MonthDayGenderUtility mdgu = new MonthDayGenderUtility();
        FirstNameUtility fnu = new FirstNameUtility();
        WisconsinFormatter wf = new WisconsinFormatter();
        FloridaFormatter ff = new FloridaFormatter();

        try {

            dl.setSoundexCode(lnu.encodeLastName(lastName));
            dl.setBirthMonthDayGender(mdgu.encodeMonthDayGender(birthYear, birthMonth, birthDate, genderCode));
            dl.setFirstNameMiddleInitial(fnu.encodeFirstName(firstName, middleInitial));
            dl.setBirthYear(birthYear);
            dl.setOverflow(overflow);

            System.out.println("Wisconsin Drivers License Number: " + wf.formatLicenseNumber(dl));
            System.out.println("Florida Drivers License Number: " + ff.formatLicenseNumber(dl));

        } catch (MissingNameException | InvalidBirthdayException | UnknownGenderCodeException e) {
            e.printStackTrace();
        }
        //after the exception block;

    }
}