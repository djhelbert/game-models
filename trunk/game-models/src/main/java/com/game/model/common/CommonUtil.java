package com.game.model.common;

import java.util.Random;

/**
 * Common Utility Class
 * 
 * @author dhelbert
 *
 */
public class CommonUtil {

	/**
	 * Get Random Number
	 * 
	 * @param max
	 * 
	 * @return int
	 */
	public static int getRandomNumber(int max) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(max);
	}
	
}
