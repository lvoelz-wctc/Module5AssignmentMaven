public class UnknownGenderCodeException extends Exception {

    //constructor to call Exception's constructor with a message that the gender code is unknown

    public UnknownGenderCodeException(char genderCode) {
        super(String.format("%c is an invalid gender code.", genderCode));
    }

}
