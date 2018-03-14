package person;

public class Renter {

    private int age;
    private int licenceHeld;
    private boolean causedAccidentLastYear;

    public Renter(int age, int licenceHeld, boolean causedAccidentLastYear) {
        this.age = age;
        this.licenceHeld = licenceHeld;
        this.causedAccidentLastYear = causedAccidentLastYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLicenceHeld() {
        return licenceHeld;
    }

    public void setLicenceHeld(int licenceHeld) {
        this.licenceHeld = licenceHeld;
    }

    public boolean isCausedAccidentLastYear() {
        return causedAccidentLastYear;
    }

    public void setCausedAccidentLastYear(boolean causedAccidentLastYear) {
        this.causedAccidentLastYear = causedAccidentLastYear;
    }
}
