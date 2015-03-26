package com.FCI.SWE.Models;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * <h1>User Entity class</h1>
 * <p>
 * This class will act as a model for user, it will holds user data
 * </p>
 *
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 */
public class UserEntity {
	private String name;
	private String email;
	private String password;
	private String friendname;
<<<<<<< HEAD
	private String friendname1;
	private String username;
	private String message;
=======
	private String username;
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
	/**
	 * Constructor accepts user data
	 * 
	 * @param name
	 *            user name
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public UserEntity(String name, String email, String password ) {
		this.name = name;
		this.email = email;
		this.password = password;		
	}
<<<<<<< HEAD
	public UserEntity( String message, String friendname,String name,String email ) {
		this.message = message;
		this.friendname = friendname;
		this.name = name;
		this.email = email;
		
	}
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
	
	/*public UserEntity(String emailsender, String emailreciever ) {
		this.emailsender = emailsender;
		this.emailreciever = emailreciever;
	}*/
	
	public UserEntity( String friendname,String username){
		
		this.friendname=friendname;
		this.username=username;

	}
<<<<<<< HEAD
public UserEntity( String friendname,String name,String friendname1,String email,String message){
		this.message=message;
		this.friendname=friendname;
		this.friendname1=friendname1;
		this.name=name;
		this.message=message;
	}
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
  
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}
	
	public String friendname() {
		return friendname;
	}
	public String username() {
		return username;
	}
<<<<<<< HEAD
	public String getmessage() {
		return message;
	}
	
	
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
	
	public static UserEntity getUser(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity(object.get("name").toString(), object.get(
					"email").toString(), object.get("password").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public static UserEntity getaccept(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity(object.get("name").toString(), object.get(
					"friendname").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
<<<<<<< HEAD
	///////////////////////////////////////////////////////////////
	public static UserEntity getmessage(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity(object.get("message").toString(), object.get(
					"friendname").toString(),object.get("name").toString(), object.get(
							"email").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
=======
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
	public static UserEntity getfriend(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity(object.get("friendname").toString(),object.get("username").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	/**
	 * 
	 * This static method will form UserEntity class using user name and
	 * password This method will serach for user in datastore
	 * 
	 * @param name
	 *            user name
	 * @param pass
	 *            user password
	 * @return Constructed user entity
	 */

	public static UserEntity getUser(String name, String pass) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("password").toString().equals(pass)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				return returnedUser;
			}
		}

		return null;
	}
	////////////////////////////////////////////////////////////////////////////
	/*public static UserEntity getaccept(String name, String friendname) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("accepts");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("friendname").toString().equals(friendname)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("friendname")
						.toString());
				return returnedUser;
			}
		}

		return null;
	}*/

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
	public Boolean saveUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("users", list.size() + 1);

		employee.setProperty("name", this.name);
		employee.setProperty("email", this.email);
		employee.setProperty("password", this.password);

		
		datastore.put(employee);

		return true;

	}////////////////////////////////////////////////////////////////////////////
	public static UserEntity getfriend(String friendname, String username) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("friendname").toString());
			if (entity.getProperty("username").toString().equals(username)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("friendname").toString(),entity.getProperty("username").toString());
				return returnedfriend;
			}
		}

		return null;
	}
<<<<<<< HEAD
	/////////////////////////////////////////////////////////////////////
	public static UserEntity getmessage(String message, String friendname,String name,String email) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("messages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("friendname").toString());
			if (entity.getProperty("name").toString().equals(name)
					&&entity.getProperty("message").toString().equals(message)
					&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("friendname").toString()
						,entity.getProperty("name").toString(),entity.getProperty("message").toString()
						,entity.getProperty("email").toString());
				return returnedfriend;
			}
		}

		return null;
	}
	//////////////////////////////////////////////////////////////
	public static UserEntity getmessage(String message, String friendname,String friendname1,String name,String email) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("groupmessages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("friendname").toString());
			System.out.println(entity.getProperty("friendname1").toString());
			if (entity.getProperty("name").toString().equals(name)
					&&entity.getProperty("message").toString().equals(message)
					&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("friendname").toString(),
						 entity.getProperty("friendname1").toString()
						 
						,entity.getProperty("name").toString(),entity.getProperty("message").toString()
						,entity.getProperty("email").toString());
				return returnedfriend;
			}
		}

		return null;
	}
=======
	
	
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
<<<<<<< HEAD
	public Boolean savefriend() {//////////////
=======
	public Boolean savefriend() {///////////////نحط برامتير للفانكشن التالتة 
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("users");/////////////////////////////////////request
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("users", list.size() + 1);

		employee.setProperty("friendname", this.friendname);
		employee.setProperty("username", this.username);
		employee.setProperty("Status", "unaccept");

		
		datastore.put(employee);

		return true;

	}
////////////////////////////////////////////////////////////////////////////////////////////////
	public Boolean saveaccept(String name, String friendname) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("accepts");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("accepts", list.size() + 1);

		employee.setProperty("name", this.username);
		employee.setProperty("friendname",this.friendname);
		employee.setProperty("status", "accept");

		
		datastore.put(employee);

		return true;

	}
<<<<<<< HEAD
	//////////////////////////////////////////////////////////////////////////////////////////////
	public Boolean savemessage() {//////////////
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("messages");/////////////////////////////////////request
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("messages", list.size() + 1);

		employee.setProperty("friendname", this.friendname);
		employee.setProperty("name", this.name);
		employee.setProperty("message", this.message);
		employee.setProperty("email", this.email);
		employee.setProperty("status", "not seen");
		
		datastore.put(employee);

		return true;

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Boolean savemessageseen() {//////////////
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("messages");/////////////////////////////////////request
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("messages", list.size() + 1);

		employee.setProperty("friendname", this.friendname);
		employee.setProperty("name", this.name);
		employee.setProperty("message", this.message);
		employee.setProperty("email", this.email);
		employee.setProperty("status", "seen");
		
		datastore.put(employee);

		return true;

	}

////////////////////////////////////////////////////////////////
public Boolean savegroupmessage() {//////////////
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();
	Query gaeQuery = new Query("groupmessages");/////////////////////////////////////request
	PreparedQuery pq = datastore.prepare(gaeQuery);
	List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
	Entity employee = new Entity("groupmessages", list.size() + 1);
	employee.setProperty("friendname", this.friendname);
	employee.setProperty("friendname1", this.friendname);
	employee.setProperty("name", this.name);
	employee.setProperty("message", this.message);
	employee.setProperty("email", this.email);
	employee.setProperty("status", "not seen");
	datastore.put(employee);
	return true;

}
}

=======
}
>>>>>>> 815aa281f84a133b9fb5e6952f5bae6a50ec10af
	

