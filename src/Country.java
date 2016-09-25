import jodd.json.JsonSerializer;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by brettgrist on 9/23/16.
 */
public class Country {

    public static HashMap<String, ArrayList <Countries>> country0 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //String[] names = {""};
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        readFile(fileScanner);


        boolean deezNutz = true;
        String firstLetter = null;
        while (deezNutz) {
            System.out.println("Enter a letter");
            Scanner scanner = new Scanner(System.in);
            firstLetter = scanner.nextLine();
            System.out.println(country0.get(firstLetter));
            if (firstLetter.equalsIgnoreCase("/exit")) {
                deezNutz = false;
            }
        }

        ArrayList<Countries> countriesArray;
        countriesArray = country0.get(firstLetter);
        File f2 = new File(firstLetter + "_countries.txt");
        FileWriter writeText = new FileWriter(f2);
        for (Countries myCountry : countriesArray){
            writeText.write(myCountry.toString()+"\n");
        }
        writeText.close();


        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper countryWrapper = new CountryWrapper();
        String json = serializer.serialize(countryWrapper);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static void readFile (Scanner fileScanner) {
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
    }
}

