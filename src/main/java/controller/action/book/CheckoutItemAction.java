package controller.action.book;

import controller.Action;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutItemAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
/*      Item itemToBeCheckedOut = new Item(inputDriver.getUserInput());
        if (library.checkoutItem(itemToBeCheckedOut, userAction)) {
            outputDriver.print(Message.SUCCESSFUL_ITEM_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_ITEM_CHECKOUT);
        }*/
    }
}
