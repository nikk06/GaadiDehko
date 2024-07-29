package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class udpateservice {
   @Autowired
	private Sellerrepo selrepo;
   @Autowired
	private Buyerrepo byrepo;
	public boolean updatePassword(String demaill, String dpasssowrd)
	{	
		int updatedRows=selrepo.updatePasswordByEmail(demaill, dpasssowrd);
		return updatedRows>0;
	}
	
	
	public boolean updatePasswordd(String demailll, String dpasssowrdd)
	{	
		int updatedRowss=byrepo.updatePasswordByEmaill(demailll, dpasssowrdd);
		return updatedRowss>0;
	}
}
