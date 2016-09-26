import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by brettgrist on 9/24/16.
 */
public class TestReadFile {

    private Object contains;

    @Test
    public void testReadFile() throws FileNotFoundException {
        //Given txt file
        File f = new File("Countries.txt");

        // what it should do

        // assertions


        HashMap<String, ArrayList<Countries>> country0 = new HashMap<>();
        Scanner fileScanner = new Scanner(f);

        ArrayList<Countries> namesArr = new ArrayList<>();
        while (fileScanner.hasNext()) {
            String file = fileScanner.nextLine();

            String[] list = file.split("\\|");
            String theAbreviation = list[0];
            String theName = list[1];

            Countries country = new Countries();
            country.abreviation = theAbreviation;
            country.name = theName;

            namesArr.add(country);
        }
        assertTrue(namesArr.size() == 241);
        assertFalse(namesArr.size() != 241);
            //end while loop
//            for (Countries myCountry : namesArr) {
//                ArrayList<Countries> theCountries = country0.get(myCountry.name.substring(0, 1));
//                if (theCountries == null) {
//                    theCountries = new ArrayList<>();
//                    country0.put(myCountry.name.substring(0, 1), theCountries);
//                }
////                assertTrue(namesArr.size() == 240);
////                assertFalse(namesArr.size() != 240);
//            }
    }
}