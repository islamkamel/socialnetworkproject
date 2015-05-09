package com.FCI.SWE.Services;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.UserEntity;

/**
 * This class contains REST services, also contains action function for web
 * application
 * 
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 *
 */
@Path("/")
@Produces("text/html")
public class Service {	
	/*@GET
	@Path("/index")
	public Response index() {
		return Response.ok(new Viewable("/jsp/entryPoint")).build();
	}*/
		/**
	 * Registration Rest service, this service will be called to make
	 * registration. This function will store user data in data store
	 * 
	 * @param uname
	 *            provided user name
	 * @param email
	 *            provided user email
	 * @param pass
	 *            provided password
	 * @return Status json
	 */
	@POST
	@Path("/RegistrationService")
	public String registrationService(@FormParam("uname") String uname,
			@FormParam("email") String email, @FormParam("password") String pass) {
		UserEntity user = new UserEntity(uname, email, pass);
		user.saveUser();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	////////////////////////////
	@POST
	@Path("/timeline")
	public String registrationService() {
		UserEntity user = new UserEntity();
		//user.saveUser();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	@Path("/likepage")
	public String likpage() {
		UserEntity user = new UserEntity();
		user.savelikepage();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	//////////////////////////////////////
	@POST
	@Path("/createpage")
	public String createpage( @FormParam("namepage") String namepage,
			@FormParam("name") String name,@FormParam("typepage") String typepage,@FormParam("ownerpage") String ownerpage,
			@FormParam("numberlikes") String numberlikes,
			@FormParam("email") String email) {
		UserEntity user = new UserEntity(namepage,name,typepage, ownerpage, numberlikes, email);
		user.savecreatepage();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	
	
	///////////////////////////////////////////////////////
	@POST
	@Path("/acceptrequest")
	public String acceptrequist(@FormParam("friendname") String emailsender,
			@FormParam("name") String emailreciever) {
		emailsender ="test";
		emailreciever ="mariam";
		UserEntity user = new UserEntity(emailsender,emailreciever);
		user.saveaccept("name","friendname");
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	
	
	@POST	
	@Path("/signoutService")
	public String signoutService() {
			
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	
	
	@POST
	@Path("/notify")
	public String notification() {
			
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	@POST
	@Path("/addfriend")
	public String addfriend(@FormParam("friendname") String friendname,@FormParam("username") String username) {
    	System.out.print("addfriend");
		UserEntity user = new UserEntity(friendname,username);
		user.savefriend();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	@POST
	@Path("/sendmessage")
	public String sendmessage(@FormParam("friendname") String friendname,@FormParam("name") String name,
			@FormParam("message") String message,
			@FormParam("email") String email) {
    	System.out.print("sendmessage");
		UserEntity user = new UserEntity(friendname,message,name,email);
    	System.out.println("MSG:" + message);
		user.savemessage();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
//////////////////////////////////////////////////////
	@POST
	@Path("/createpost")
	public String createpost(
			@FormParam("post") String post,@FormParam("friendname") String friendname,@FormParam("id") int id) {
    	System.out.print("createpost");
		UserEntity user = new UserEntity(post,friendname,id);
    	System.out.println("post:" + post);
    	System.out.println("post:" + friendname);
    	System.out.println("post:" + id);
		user.savepost();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	@POST
	@Path("/groupmessage")
	public String groupmessage(@FormParam("friendname") String friendname,@FormParam("friendname1  ") String friendname1,@FormParam("name") String name,
			@FormParam("message") String message,
			@FormParam("email") String email) {
    	System.out.print("groupmessage");
		UserEntity user = new UserEntity(friendname,message,name,email);
		user.savegroupmessage();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}

	/**
	 * Login Rest Service, this service will be called to make login process
	 * also will check user data and returns new user from datastore
	 * @param uname provided user name
	 * @param pass provided user password
	 * @return user in json format
	 */
	@POST
	@Path("/LoginService")
	public String loginService(@FormParam("uname") String uname,
			@FormParam("password") String pass) {
		JSONObject object = new JSONObject();
		UserEntity user = UserEntity.getUser(uname, pass);
		if (user == null) {
			object.put("Status", "Failed");

		} else {
			object.put("Status", "OK");
			object.put("name", user.getName());
			object.put("email", user.getEmail());
			object.put("password", user.getPass());
		}

		return object.toString();

	}

}