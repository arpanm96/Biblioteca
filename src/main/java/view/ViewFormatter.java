package view;

import java.util.ArrayList;
import java.util.Collection;

/*
A class to format the details to be displayed in a certain manner
*/

public class ViewFormatter {
    public Collection<String> formatAccordingToColomns(Collection<String> bookDetails) {
        Collection<String> formattedString = new ArrayList<>();
        for (String book : bookDetails) {
            String splittedString[] = book.split(",");
            String output = "";
            for (String s : splittedString) {
                output += padRight(s, 30);
            }
            ((ArrayList<String>) formattedString).add(output);
        }
        return formattedString;
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
}
