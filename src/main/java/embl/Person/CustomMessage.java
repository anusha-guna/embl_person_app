package embl.Person;

public class CustomMessage {
	 
    private String message;
 
    public CustomMessage(String errorMessage){
        this.message = errorMessage;
    }
 
    public String getMessage() {
        return message;
    }
 
}
