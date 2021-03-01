import org.apache.commons.codec.language.Soundex;

public class LastNameUtility {
    Soundex soundex = new Soundex();

    public String encodeLastName(String lastName) throws MissingNameException {
        if (lastName==null){
            throw new MissingNameException();
        }
        else {
            return soundex.encode(lastName);
        }
    }
}
