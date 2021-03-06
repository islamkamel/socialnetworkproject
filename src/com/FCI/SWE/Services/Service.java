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
<<<<<<< HEAD
	
	
	@POST
	@Path("/notify")
	public String notification() {
			
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
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
<<<<<<< HEAD
	@POST
	@Path("/sendmessage")
	public String sendmessage(@FormParam("friendname") String friendname,@FormParam("name") String name,
			@FormParam("message") String message,
			@FormParam("email") String email) {
    	System.out.print("sendmessage");
		UserEntity user = new UserEntity(friendname,message,name,email);
		user.savemessage();
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
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af

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