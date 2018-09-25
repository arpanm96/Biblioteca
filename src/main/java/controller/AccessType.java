package controller;

import model.user.UserAction;

/*
An enum to check if the user has logged in or not to access various menus
*/

public enum AccessType {
    ALWAYS {
        @Override
        public boolean isMenuAccessValid(UserAction userAction) {
            return true;
        }
    },
    LOGGED_IN {
        @Override
        public boolean isMenuAccessValid(UserAction userAction) {
            return userAction.isUserLoggedIn();
        }
    },
    NOT_LOGGED_IN {
        @Override
        public boolean isMenuAccessValid(UserAction userAction) {
            return !userAction.isUserLoggedIn();
        }
    };

    abstract public boolean isMenuAccessValid(UserAction userAction);
}
