package com.FCI.SWE.Controller;

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
import java.util.Vector;//////////////////////////////////////////

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
public class UserController {
	/**
	 * Action function to render Signup page, this function will be executed
	 * using url like this /rest/signup
	 *
	 * @return sign up page
	 */
	/*
	 * this function sign up register accounts and
	 * insert name ,password ,email
	 *
	 *
	 */
	@GET
	@Path("/signup")
	//this function sign up register accounts and  insert name ,password ,email
	public Response signUp() {
		return Response.ok(new Viewable("/jsp/register")).build();
	}
	/*
	 * this function contain create post and like post
	 *
	 *
	 *
	 */

	@GET
	@Path("/timeline")
	// function contain create post and like post
	public Response timeline() {
		return Response.ok(new Viewable("/jsp/timeline")).build();
	}
	/*
	 * this function contain hash tag
	 */
	@GET
	@Path("/trends")
	//this function contain hash tag
	public Response trend() {
		return Response.ok(new Viewable("/jsp/trends")).build();
	}
	/*
	 *
	 * this function contain information about the page that it will be created
	 */
	@GET
	@Path("/createpage")
	//this function contain information about the page that it will be created
	public Response createpage() {
		return Response.ok(new Viewable("/jsp/createpage")).build();
	}
    /*
     * to exit from own page
     *
     *
     */
	@Path("/signout")
	//o exit from own page
	public Response signout() {
		return Response.ok(new Viewable("/jsp/signout")).build();
	}
     /*
      * this contain the notification about messages and requested friends
      *
      */
	@Path("/notify")
	//this contain the notification about messages and requested friends
	public Response notification() {
		return Response.ok(new Viewable("/jsp/notify")).build();
	}

	@GET
	@Path("/createpost")
	public Response createpost() {//////////////////////////////////////////////////////////////////////////
		return Response.ok(new Viewable("/jsp/createpost")).build();
	}

	@GET

	@Path("/addfriend")
	public Response addfriend() {//////////////////////////////////////////////////////////////////////////
		return Response.ok(new Viewable("/jsp/addfriend")).build();
	}

	@GET
	@Path("/sendmessage")
	public Response sendmessage() {//////////////////////////////////////////////////////////////////////////
		return Response.ok(new Viewable("/jsp/sendmessage")).build();
	}


	@GET
	@Path("/acceptrequest")
	public Response acceptrequest() {//////////////////////////////////////////////////////////////////////////
		return Response.ok(new Viewable("/jsp/acceptrequest")).build();
	}

	@GET
	@Path("/groupmessage")
	public Response groupmessage() {//////////////////////////////////////////////////////////////////////////
		return Response.ok(new Viewable("/jsp/groupmessage")).build();
	}

	/**
	 * Action function to render home page of application, home page contains
	 * only signup and login buttons
	 *
	 * @return enty point page (Home page of this application)
	 */
	@GET
	@Path("/")
	public Response index() {
		return Response.ok(new Viewable("/jsp/entryPoint")).build();
	}

	/**
	 * Action function to render login page this function will be executed using
	 * url like this /rest/login
	 *
	 * @return login page
	 */
	@GET
	@Path("/login")
	public Response login() {
		return Response.ok(new Viewable("/jsp/login")).build();
	}

	/**
	 * Action function to response to signup request, This function will act as
	 * a controller part and it will calls RegistrationService to make
	 * registration
	 *
	 * @param uname
	 *            provided user name
	 * @param email
	 *            provided user email
	 * @param pass
	 *            provided user password
	 * @return Status string
	 */
	@POST

	@Path("/createpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("namepage") String namepage,
			@FormParam("name") String name,@FormParam("typepage") String typepage,@FormParam("ownerpage") String ownerpage,
			@FormParam("numberlikes") String numberlikes,
			@FormParam("email") String email) {
		String serviceUrl = "http://localhost:8888/rest/createpage";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&namepage=" + namepage +"&name=" + name +"&typepage=" + typepage +"&ownerpage=" + ownerpage +"&numberlikes=" +
			numberlikes + "&email=" + email;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;

			if (object.get("Status").equals("OK"))
				return "Create Page Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceUrl;
	}
		///////////////////////////////
		@POST
		@Path("/likepage")
		@Produces(MediaType.TEXT_PLAIN)
		public String responsee(@FormParam("namepage") String namepage,
				@FormParam("name") String name,@FormParam("typepage") String typepage,@FormParam("ownerpage") String ownerpage,
				@FormParam("numberlikes") String numberlikes,
				@FormParam("email") String email) {
			String serviceUrl = "http://localhost:8888/rest/likepage";
			try {
				URL url = new URL(serviceUrl);
				String urlParameters = "&namepage=" + namepage +"&name=" + name +"&typepage=" + typepage +"&ownerpage=" + ownerpage +"&numberlikes=" +
				numberlikes + "&email=" + email;
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setInstanceFollowRedirects(false);
				connection.setRequestMethod("POST");
				connection.setConnectTimeout(60000);  //60 Seconds
				connection.setReadTimeout(60000);  //60 Seconds
				connection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				OutputStreamWriter writer = new OutputStreamWriter(
						connection.getOutputStream());
				writer.write(urlParameters);
				writer.flush();
				String line, retJson = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));

				while ((line = reader.readLine()) != null) {
					retJson += line;
				}
				writer.close();
				reader.close();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(retJson);
				JSONObject object = (JSONObject) obj;

				if (object.get("Status").equals("OK"))
					return "UN LIKE";
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}
	@POST

	@Path("/response")
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("uname") String uname,
			@FormParam("email") String email, @FormParam("password") String pass) {
		String serviceUrl = "http://localhost:8888/rest/RegistrationService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "uname=" + uname + "&email=" + email
					+ "&password=" + pass;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;

			if (object.get("Status").equals("OK"))
				return "Registered Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}

	/**
	 * Action function to response to login request. This function will act as a
	 * controller part, it will calls login service to check user data and get
	 * user from datastore
	 *
	 * @param uname
	 *            provided user name
	 * @param pass
	 *            provided user password
	 * @return Home page view
	 */
	@POST
	@Path("/home")
	@Produces("text/html")
	public Response home(@FormParam("uname") String uname,
			@FormParam("password") String pass) {
		String serviceUrl = "http://localhost:8888/rest/LoginService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "uname=" + uname + "&password=" + pass;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return null;
			Map<String, String> map = new HashMap<String, String>();
			UserEntity user = UserEntity.getUser(object.toJSONString());
			map.put("name", user.getName());
			map.put("email", user.getEmail());

			map.put("post", user.getpost());

			return Response.ok(new Viewable("/jsp/home", map)).build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}

	///////////////////////////////
	@POST
	@Path("/trends")
	@Produces("text/html")
	public Response home() {
		String serviceUrl = "http://localhost:8888/rest/LoginService";
		try {
			URL url = new URL(serviceUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());

			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return null;
			Map<String, String> map = new HashMap<String, String>();
			UserEntity user = UserEntity.getUser(object.toJSONString());

			return Response.ok(new Viewable("/jsp/trends", map)).build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
	////////////////////////

	@POST
	@Path("/signout")
	@Produces(MediaType.TEXT_PLAIN)
	public String response()  {
		String serviceUrl = "http://localhost:8888/rest/signoutService";
		try {
			URL url = new URL(serviceUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");


			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));


			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = null ;
			JSONObject object = (JSONObject)obj;
			if (object.get("Status").equals("OK"))
				return "signout Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}
    ////////////////////////////////////////////////////////////////////////////////////Add friend///////////////////
	@POST
	@Path("/addFriend")///////////////////////////send request
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("friendname") String friendname,@FormParam("username") String username) {
		String serviceUrl = "http://localhost:8888/rest/addfriend";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "friendname=" + friendname+"username"+username ;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
           System.out.print("ffffffffffffffff");
			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Send Request Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}
	@POST
	@Path("/acceptrequest")///////////////////////////send request
	@Produces(MediaType.TEXT_PLAIN)
	public String responsee(@FormParam("friendname") String friendname,@FormParam("uname") String uname) {
		String serviceUrl = "http://localhost:8888/rest/acceptrequest";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "friendname=" + friendname+"uname"+uname ;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
           System.out.print("ffffffffffffffff");
			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Send Request Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}

	/////////////////////////////////////////////////////////////////////////////////
	@POST
	@Path("/sendmessage")///////////////////////////send request
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("friendname") String friendname,@FormParam("name") String name,
			@FormParam("message") String message,
			@FormParam("email") String email) {
		String serviceUrl = "http://localhost:8888/rest/sendmessage";
		try {
			URL url = new URL(serviceUrl);

			String urlParameters = "&friendname=  " + friendname+"&name=  "+name+"&message=   "+message+"&email=   "+email;

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
           System.out.print("ffffffffffffffff");
			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Send message Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
	}
	@POST
	@Path("/groupmessage")///////////////////////////send request
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("friendname") String friendname,
			@FormParam("friendname1") String friendname1,
			@FormParam("name") String name,
			@FormParam("message") String message,
			@FormParam("email") String email) {

	 System.out.println(friendname+ friendname1+name+message+email);

		String serviceUrl = "http://localhost:8888/rest/groupmessage";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&friendname= " + friendname+"&friendname1= " + friendname1+"&name= "+name+message+"&message= "+email+"&email= " ;

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
           System.out.print("ffffffffffffffff");
			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Send message Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
	}
	@POST

	@Path("/createpost")///////////////////////////send request
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("post") String post,@FormParam("friendname") String friendname,@FormParam("post") int id) {
	 System.out.println(post);
	 System.out.println(friendname);
	 System.out.println(id);
		String serviceUrl = "http://localhost:8888/rest/createpost";
		try {
			URL url = new URL(serviceUrl);

			String urlParameters = "&post= " + post+"&friendname= " + friendname+"&id= "+id  ;
			HttpURLConnection connection =
					(HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
           System.out.print("ffffffffffffffff");
			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "create post Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
	}
	@POST

	@Path("/notify")
	@Produces(MediaType.TEXT_PLAIN)
	public String responsee()  {
		String serviceUrl = "http://localhost:8888/rest/notify";
		try {
			URL url = new URL(serviceUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");


			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));


			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = null ;
			JSONObject object = (JSONObject)obj;
			if (object.get("Status").equals("OK"))
				return "notification Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";
	}

	////////////////////////////////
	@POST
	@Path("/timeline")
	@Produces(MediaType.TEXT_PLAIN)
	public String time()  {
		String serviceUrl = "http://localhost:8888/rest/timeline";
		try {
			URL url = new URL(serviceUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000);  //60 Seconds
			connection.setReadTimeout(60000);  //60 Seconds
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");


			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));


			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = null ;
			JSONObject object = (JSONObject)obj;
			if (object.get("Status").equals("OK"))
				return "Welcome to timeline ";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return "Failed";

	}



	}




