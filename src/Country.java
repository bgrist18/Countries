import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by brettgrist on 9/23/16.
 */
public class Country {

    public static HashMap<String, ArrayList <Countries>> country0 = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //String[] names = {""};
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String file = fileScanner.nextLine();
            String[] list = file.split("\\|");
            String theAbreviation = list[0];
            String theName = list[1];
            Countries country = new Countries();
            country.abreviation = theAbreviation;
            country.name = theName;
            ArrayList<Countries> namesArr = new ArrayList<>();
            namesArr.add(country);
            for (Countries myCountry : namesArr) {
                ArrayList<Countries> theCountries = country0.get(country.name.substring(0, 1));
                if (theCountries == null) {
                    theCountries = new ArrayList<>();
                    country0.put(myCountry.name.substring(0, 1), theCountries);
                }
                theCountries.add(myCountry);
            }
        }
        boolean deezNutz = true;
        while (deezNutz){
            System.out.println("Enter a letter");
            Scanner scanner = new Scanner(System.in);
            String firstLetter = scanner.nextLine();
            System.out.println(country0.get(firstLetter));
            if (firstLetter.equalsIgnoreCase("/exit")) {
                deezNutz = false;
            }

        }
    }
}

