 package br.com.deyvison.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -3716497993558484841L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
