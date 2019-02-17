package com.sindhe.service;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sindhe.model.Website;

@Path("/records")
public class RESTEasyHelloWorldService {
	// http://zetcode.com/jaxrs/resteasycrud/
	// https://www.9lessons.info/2012/09/restful-web-services-api-using-java-and.html
	//https://www.journaldev.com/9189/resteasy-tutorial-eclipse-tomcat
	ServiceImpl ser;
	@GET
	@Path("getById/{ById}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Website> getRecordById(@PathParam("ById") int id) {
		return new ServiceImpl().getRecordsById(id);
	}

	@GET
	@Path("getAll/Records")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Website> getAllRecords() {
		return new ServiceImpl().getAllRecords();
	}

	@POST
	@Path("user/{title}/{description}/{url}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> userRegisters(@PathParam("title") 
	String title, @PathParam("description") String description, @PathParam("url") String url){
		int i=0;
		i=new ServiceImpl().userRegister(title, description, url);
		HashMap<String, String> map = new HashMap<String, String>();
		if(i>0) {
			map.put("Id", " Reocrd saved successfully ");
		}
		else {
			map.put("Id", "Something went wrong");
		}
		return map;
	}

	@DELETE
	@Path("delete/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> deleteByIds(@PathParam("id") int id) {
		System.out.println("{id} " + id);
		int i = 0;
		i = new ServiceImpl().deleteById(id);
		System.out.println("delete/{id} " + i);
		HashMap<String, String> map = new HashMap<String, String>();
		if (i > 0) {
			map.put("Id", id + " Deleted");
		} else {
			map.put("Id", "Failed");
		}
		return map;
	}
	
	@POST
	@Path("/userw")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> registerUser(Website website){
		HashMap<String , String>  hs=new HashMap<>();
		int i=0;
		i=new ServiceImpl().registerUsers(website);
		if(i>0) {
			hs.put("Status", "SUCCESS");
		}
		else {
			hs.put("Status", "FAILED");
		}
		
		return hs;
	}
	

	@PUT
	@Path("/userUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> updateUser(Website website){
		HashMap<String , String>  hs=new HashMap<>();
		int i=0;
		i=new ServiceImpl().updateUsers(website);
		if(i>0) {
			hs.put("Status", "SUCCESS");
		}
		else {
			hs.put("Status", "FAILED");
		}
		
		return hs;
	}
}