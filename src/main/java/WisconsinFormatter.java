public class WisconsinFormatter implements DriversLicenseFormatter{

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        //return SSSS-FFFY-YDDD-NN (Soundex - FFF = sum of first name and middle initial codes, YY = two year birth digit, DDD = md/gender. nn=0
        String soundexCode = driversLicense.getSoundexCode();
        String initialCode = String.valueOf(driversLicense.getFirstNameMiddleInitial());
        String yearCode = String.valueOf(driversLicense.getBirthYear());
        String genderCode = String.valueOf(driversLicense.getBirthMonthDayGender());
        String overflow = String.valueOf(driversLicense.getOverflow());

        String yearOne = String.valueOf(yearCode.charAt(0));
        String yearTwo = String.valueOf(yearCode.charAt(1));

        String driversLicenseNumber = soundexCode+"-"+initialCode+yearOne+"-"+yearTwo+genderCode+"-"+overflow+"0";

        return driversLicenseNumber;
    }
}
