
import java.util.Arrays;
import javax.swing.JOptionPane;

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

    public static String[] names = new String[50];

    public String insert(String name) {
        if (validate(name)) {
            return "error";
        }

        int nextIndex = getLastIndex(names) == 0 ? getLastIndex(names) : getLastIndex(names) + 1;

        names[nextIndex] = name;

        return names[nextIndex];
    }
    
    public String[] all() {
        return Arrays.stream(names)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }
    
    public String find(String name) {
        boolean isFound = containsCaseInsensitive(name, names);
        
        if (isFound) {
            return "A palavra: " + name + " se encontra em nossos registros. Na posiçao: " + Arrays.asList(toLowerCase(names)).indexOf(name.toLowerCase());
        }
        
        return "A palavra: " + name + " nao se encontra em nossos registros";
    }
    
    private String[] toLowerCase(String[] names)
    {
        String[] inLower = new String[50];
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                inLower[i] = names[i].toLowerCase();
            }else {
                inLower[i] = names[i].toLowerCase();
            }
        }
        
        return inLower;
    }

    private boolean containsCaseInsensitive(String name, String[] names) {
        for (String string : names) {
            if (string == null) {
                return false;
            }

            if (string.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private static int getLastIndex(String[] array) {
        int counter = 0;
        for (String array1 : array) {
            if (array1 != null) {
                counter++;
            }
        }

        return counter;
    }

    private boolean validate(String name) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite ao menos uma letra!");
            return true;
        }

        if (name.isEmpty() || containsCaseInsensitive(name, names)) {
            JOptionPane.showMessageDialog(null, "Este nome ja foi adicionado!");
            return true;
        }

        if (getLastIndex(names) == 50) {
            JOptionPane.showMessageDialog(null, "Banco de dados cheio!"
                    + "\nContate o administrador.");
            return true;
        }

        return false;
    }
}
