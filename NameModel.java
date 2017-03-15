
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class NameModel {
    public static String[] names = new String[255];
    
    public String[] insert(String name)
    {
        int nextIndex = getLastIndex(names) == 0 ? getLastIndex(names): getLastIndex(names) + 1;
        
        names[nextIndex] = name;
        
        return names;
    }
    
    public String[] all()
    {
        return Arrays.stream(names)
                     .filter(s -> (s != null && s.length() > 0))
                     .toArray(String[]::new);
    }
    
    private static int getLastIndex(String[] array)
    {
        int counter = 0;
        for (String array1 : array) {
            if (array1 != null) {
                counter ++;
            }
        }
        
        return counter;
    }
}
