package com.test;

import com.sindhe.model.Website;
import com.sindhe.service.ServiceImpl;

public class Test {
//https://codereview.stackexchange.com/questions/126621/simple-singleton-database-connection-pool
	@org.junit.Test
	public void Tests() {

		/*System.out.println(new ServiceImpl().getRecordsById(1));
		List<Website> list = new ServiceImpl().getAllRecords();
		System.out.println(list);
		System.out.println(new ServiceImpl().userRegister("Samsung", "Samsung 8", "https://Samsung.com"));
		*/
		Website website=new Website();
		website.setTitle("hi");
		website.setDescription("hi");
		website.setUrl("url");
		website.setId(50);
		
		//System.out.println(new ServiceImpl().registerUsers(website));
		System.out.println(new ServiceImpl().updateUsers(website));
		

	}
}
