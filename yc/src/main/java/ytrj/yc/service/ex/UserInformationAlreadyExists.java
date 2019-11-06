package ytrj.yc.service.ex;

public class UserInformationAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -473629836350600062L;
	
	public UserInformationAlreadyExists() {
		
	}
	
	public UserInformationAlreadyExists(String message) {
		super(message);
	}

}
