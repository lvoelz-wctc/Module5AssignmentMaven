public class FloridaFormatter implements DriversLicenseFormatter {

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        //return SSSS-FFFY-YDDD-NN (Soundex - FFF = sum of first name and middle initial codes, YY = two year birth digit, DDD = md/gender. nn=0
       String soundexCode = driversLicense.getSoundexCode();
       String initialCode = String.valueOf(driversLicense.getFirstNameMiddleInitial());
       String yearCode = String.valueOf(driversLicense.getBirthYear());
       String genderCode = String.valueOf(driversLicense.getBirthMonthDayGender());
       String overflow = String.valueOf(driversLicense.getOverflow());

       String driversLicenseNumber = soundexCode+"-"+initialCode+"-"+yearCode+"-"+genderCode+"-"+overflow;

        return driversLicenseNumber;
    }
}
