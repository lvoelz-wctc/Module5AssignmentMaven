public class MissingNameException extends Exception {
    public MissingNameException() {
        super(String.format("Supplied name may not be blank!"));
    }
}
