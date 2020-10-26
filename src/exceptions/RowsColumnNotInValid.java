package exceptions;

public class RowsColumnNotInValid extends Exception {
    @Override
    public String getMessage() {
        return "error: rows and cols not invalid";
    }
}
