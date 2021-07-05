package jsonreverser;

class MessageDTO{

	
	int id;
	String message;
	
	public MessageDTO() {
		
	}
	
	public MessageDTO(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", message=" + message + "]";
	}
	
	public String reverseMessage() {
		return new StringBuilder(this.message).reverse().toString();
	}
	
	
	
}