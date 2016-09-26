import java.util.ArrayList;

/**
 * Created by brettgrist on 9/23/16.
 */
public class CountryWrapper {
        ArrayList<Countries> country;

        public CountryWrapper(ArrayList<Countries> country) {
            this.country = country;
        }

        public ArrayList<Countries> getCountry() {
            return country;
        }

        public void setCountry(ArrayList<Countries> country) {
            this.country = country;
        }
    }
