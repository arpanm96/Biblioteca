import common.Message;
import view.OutputDriver;


class Library {
    Library(OutputDriver outputDriver) {
        outputDriver.printWelcomeMessage(Message.WELCOME);
    }
}
