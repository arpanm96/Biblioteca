package view;

import java.util.Scanner;

public class InputDriver {
    private Scanner scanner;

    public InputDriver() {
        this.scanner = new Scanner(System.in);
    }

    public int getMenuChoiceFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getBookToBeCheckedOut() {
        return scanner.nextLine();
    }

    public String getBookToBeReturned() {
        return scanner.nextLine();
    }
}
