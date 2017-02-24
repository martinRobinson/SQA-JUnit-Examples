
public class person {
    private String firstName = null;
    private String secondName = null;
    private int ageYears = 0;

    public person (){
        this("Unknown", "Unknown", 0);
    }

    public person(String firstName, String secondName, int ageYears){
        this.firstName = firstName;
        this.secondName = secondName;
        this.ageYears = ageYears;
    }

    public int getAgeInYears(){
        return ageYears;
    }
}
