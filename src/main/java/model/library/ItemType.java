package model.library;

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
