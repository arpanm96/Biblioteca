package view;

import java.util.Scanner;

/*
A class to perform all the input functions required for biblioteca
*/

public class InputDriver {
    private Scanner scanner;

    public InputDriver() {
        this.scanner = new Scanner(System.in);
    }

    public int getMenuChoiceFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }
    public String getUserInput() {
        return scanner.nextLine();
    }
}
