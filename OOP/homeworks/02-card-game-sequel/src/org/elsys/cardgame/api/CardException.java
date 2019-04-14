package org.elsys.cardgame.api;

public class CardException extends RuntimeException {

	/**
	 * 
	 */
	String error;

	CardException(String error){
		this.error = error;
	}

	private static final long serialVersionUID = 8822513014262189134L;

}
