package com.hcl.ecommerce.exception;

/**
 * This exception class has one exception method 
 * @author Vishalakshi
 *
 */
public class ProductNotFoundException extends Exception {

	/**
	 * The method used for product not found condition
	 * @param string
	 */
	public ProductNotFoundException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
