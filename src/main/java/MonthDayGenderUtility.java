import java.text.SimpleDateFormat;
import java.util.Date;

//using commons-validator-1.7.jar to test

public class MonthDayGenderUtility {
    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public boolean validDate(int month, int day, int year) {
        if (month > 12 || month < 1) {
            return false;
        }
        else if (day > 32 || day < 1) {
            return false;
        }
        else if ((month == 9 || month == 4 || month == 6 || month == 11) && day > 30) {
            return false;
        }
        else if ((month == 2) && (year%4!=0) && day > 28) {
            return false;
        }
        else if ((month == 2) && (year%4==0) && day > 29) {
            return false;
        }
        else {return true;}
    }

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException{
        //String yearString = Integer.toString(year);
        //String monthString = Integer.toString(month);
        //String dayString = Integer.toString(day);

        if (genderCode != CODE_MALE && genderCode != CODE_FEMALE ){
            throw new UnknownGenderCodeException(genderCode);
        }
        if (validDate(month, day, year) == false){
            throw new InvalidBirthdayException(year, month, day);
        }
        else
        {
            if (genderCode == CODE_MALE){
                return ((month - 1)*40+day+MOD_MALE);
            }
            else {
                return ((month - 1)*40+day+MOD_FEMALE);
            }
        }
    }
}
