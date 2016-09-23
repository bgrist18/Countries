/**
 * Created by brettgrist on 9/23/16.
 */
public class Countries {
    String abreviation;
    String name;

    public Countries() {

    }

    public Countries(String abreviation, String name) {
        abreviation = abreviation;
        this.name = name;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public String getName() {
        return name;
    }
    //    public Countries(String abreviation) {
//        Abreviation = abreviation;
//    }
//
//    public Countries(String abreviation, String name) {
//        Abreviation = abreviation;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Countries{" +
                "abreviation='" + abreviation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
