package p38g4shopms.shopms.exceptions;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(String message){
        super(message);
    }
}
