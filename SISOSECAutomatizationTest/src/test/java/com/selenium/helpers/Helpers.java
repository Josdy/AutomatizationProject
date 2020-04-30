package com.selenium.helpers;

public class Helpers {
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
}
