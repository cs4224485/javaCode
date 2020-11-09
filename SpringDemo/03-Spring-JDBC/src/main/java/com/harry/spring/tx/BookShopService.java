package com.harry.spring.tx;

import org.springframework.stereotype.Service;


public interface BookShopService {
	
	public void purchase(String username, String isbn);
	
}
