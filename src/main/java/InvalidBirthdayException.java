public class InvalidBirthdayException extends Exception {

    public InvalidBirthdayException(int year, int month, int day){
        super(String.format("%d/%d/%d is not a real day!", day, month, year));

    }

}
