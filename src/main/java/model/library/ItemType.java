package model.library;

/*
An enum to store the type of the item
*/

public enum ItemType {
    BOOK {
        @Override
        public String getItemHeaders() {
            return "Title,Author,Year Published";
        }
    }, MOVIE {
        @Override
        public String getItemHeaders() {
            return "Name,Year,Director,Movie Rating";
        }
    };

    public abstract String getItemHeaders();
}
