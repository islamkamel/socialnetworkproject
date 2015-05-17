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
 * 
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
	private String namepage;
	private String typepage;
	private String numberlikes;
	private String ownerpage;
	private String post;
	private String email;
	private String password;
	private String friendname;
	private String friendname1;
	private String username;
	private String message;
	int id;
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
	public UserEntity(String post,String friendname,int id) {
		this.post = post;
		this.friendname=friendname;
		this.id=id;
			
	}
	public UserEntity() {	
		
	}
	public UserEntity(String name, String email, String password ) {
		this.name = name;
		this.email = email;
		this.password = password;		
	}
	public UserEntity( String message, String friendname,String name,String email ) {
		this.message = message;
		this.friendname = friendname;
		this.name = name;
		this.email = email;
		
	}
	
	public UserEntity( String friendname,String username){
		
		this.friendname=friendname;
		this.username=username;

	}
public UserEntity( String friendname,String name,String friendname1,String email,String message){
		this.message=message;
		this.friendname=friendname;
		this.friendname1=friendname1;
		this.name=name;
		this.message=message;
	}
  
public UserEntity( String namepage,String name,String typepage,String ownerpage,String numberlikes,String email){
	this.namepage=namepage;
	this.name=name;
	this.typepage=typepage;
	this.ownerpage=ownerpage;
	this.numberlikes=numberlikes;
	this.email=email;
}
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}
	public String getpost() {
		return post;
	}
	public int getid() {
		return id;
	}
	
	public String friendname() {
		return friendname;
	}
	public String username() {
		return username;
	}
	public String getmessage() {
		return message;
	}
	
	
	
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
	////////////////////////////////////////////////////////
	public static UserEntity gettimeline(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	//////////////////////////////////////
	
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
	static String m;
	public static UserEntity getcreatepage(String namepage,String name,String typepage,String ownerpage,String numberlikes,String email) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query gaeQuery = new Query("pages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("namepage").toString());
			if (entity.getProperty("namepage").toString().equals(namepage)){
				m+=entity.getProperty("namepage").toString();
			}
			
			if (entity.getProperty("namepage").toString().equals(namepage)&&entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("typepage").toString().equals(typepage)&&entity.getProperty("ownerpage").toString().equals(ownerpage)
					&&entity.getProperty("numberlikes").toString().equals(numberlikes)&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"namepage").toString(), entity.getProperty("name")
						.toString(), entity.getProperty("typepage").toString(), entity.getProperty("ownerpage").toString(), 
						entity.getProperty("numberlikes").toString(), entity.getProperty("email").toString());
				return returnedUser;
			}
		}
      System.out.print(m);
		return null;
	}
	///////////////////////////////////////////////
	public static UserEntity getlikepage(String namepage,String name,String typepage,String ownerpage,String numberlikes,String email) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query gaeQuery = new Query("likes");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("namepage").toString());
			if (entity.getProperty("namepage").toString().equals(namepage)&&entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("typepage").toString().equals(typepage)&&entity.getProperty("ownerpage").toString().equals(ownerpage)
					&&entity.getProperty("numberlikes").toString().equals(numberlikes)&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"namepage").toString(), entity.getProperty("name")
						.toString(), entity.getProperty("typepage").toString(), entity.getProperty("ownerpage").toString(), 
						entity.getProperty("numberlikes").toString(), entity.getProperty("email").toString());
				return returnedUser;
			}
		}

		return null;
	}
	///////////////////////////////////

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
	public Boolean savecreatepage() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("pages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		Entity employee = new Entity("pages", list.size() + 1);
		employee.setProperty("namepage", this.namepage);
		employee.setProperty("name", this.name);
		employee.setProperty("typepage", this.typepage);
		employee.setProperty("ownerpage", this.ownerpage);
		employee.setProperty("numberlikes", this.numberlikes);
		employee.setProperty("test",this.namepage);
		employee.setProperty("email", this.email);
		datastore.put(employee);
		return true;
	}
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

	}
	////////////////////////////////////////////////////////////////////////////
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
	/////////////////////////////////////////////////////////////////////
	static String x;
	public static UserEntity getmessage(String message, String friendname,String name,String email) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("messages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("friendname").toString());
			
			if (entity.getProperty("friendname").toString().equals(name)){
				x+=entity.getProperty("message").toString();
			}
			
			if (entity.getProperty("name").toString().equals(name)
					&&entity.getProperty("message").toString().equals(message)
					&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("friendname").toString()
						,entity.getProperty("name").toString(),entity.getProperty("message").toString()
						,entity.getProperty("email").toString());
				return returnedfriend;
			}
		}
		System.out.print(x);
		return null;
	}
	static String s;
	public static UserEntity getpost(String post, String friendname,int id) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("posts");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("post").toString());
			System.out.println(entity.getProperty("friendname").toString());
			if (entity.getProperty("post").toString().equals(post)&&entity.getProperty("friendname").toString().equals(friendname)&&
					entity.getProperty("id").toString().equals(id)){
				s+=entity.getProperty("post").toString();
			}
			if (entity.getProperty("post").toString().equals(post)
					&&entity.getProperty("friendname").toString().equals(friendname)
					&&entity.getProperty("id").toString().equals(id)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("post").toString(),
						 entity.getProperty("friendname").toString()
						,entity.getProperty("id").toString(),entity.getProperty("id").toString());
				return returnedfriend;
			}
			System.out.println(s);
		}

		return null;
	}

	
//////////////////////////////////////////////////////////////
	static String y;
	public static UserEntity getmessage(String message, String friendname,String friendname1,String name,String email) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("groupmessages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("friendname").toString());
			System.out.println(entity.getProperty("friendname1").toString());
			if (entity.getProperty("friendname").toString().equals(name)&&entity.getProperty("friendname1").toString().equals(name)){
				y+=entity.getProperty("message").toString();
			}
			if (entity.getProperty("name").toString().equals(name)
					&&entity.getProperty("message").toString().equals(message)
					&&entity.getProperty("email").toString().equals(email)) {
				UserEntity returnedfriend = new UserEntity( entity.getProperty("friendname").toString(),
						 entity.getProperty("friendname1").toString()
						 
						,entity.getProperty("name").toString(),entity.getProperty("message").toString()
						,entity.getProperty("email").toString());
				return returnedfriend;
			}
			System.out.println(y);
		}

		return null;
	}

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
	public Boolean savefriend() {//////////////
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
	////////////////////////////////////
	public Boolean savelikepage() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("likes");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		Entity employee = new Entity("likes", list.size() + 1);
		employee.setProperty("namepage", this.namepage);
		employee.setProperty("name", this.name);
		employee.setProperty("typepage", this.typepage);
		employee.setProperty("ownerpage", this.ownerpage);
		employee.setProperty("numberlikes", this.numberlikes);
		//employee.setProperty("test",this.namepage);
		employee.setProperty("email", this.email);
		datastore.put(employee);
		return true;
	}
	//////////////////////////
	public Boolean savepost() {//////////////
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("posts");/////////////////////////////////////request
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		Entity employee = new Entity("posts", list.size() + 1);
		employee.setProperty("post", this.post);
		employee.setProperty("friendname", this.friendname);
		employee.setProperty("id", this.id);
		//employee.setProperty("test", this.post);
		employee.setProperty("number of likes", "5");
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
	//////////////////////////
	public Boolean savepageliked() {//////////////
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("likes");/////////////////////////////////////request
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("likes", list.size() + 1);
		
		employee.setProperty("pagename", this.namepage);
		employee.setProperty("name", this.name);
		employee.setProperty("typepage", this.typepage);
		employee.setProperty("ownerpage", this.typepage);
		employee.setProperty("numberlikes", this.numberlikes);
		employee.setProperty("email", this.email);
		employee.setProperty("status", "liked");
		
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

	

