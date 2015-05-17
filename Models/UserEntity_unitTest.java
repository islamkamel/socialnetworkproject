package com.FCI.SWE.Models;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserEntity_unitTest {
	String name= "yara";
	String email="@yara";
	String password="abcd";
	String friendname="nov";
	String emailsender="nov";
	String emailreciever="yara";
	String namepage="Study";
	String typepage="social";
	String ownerpage="me";
	String numberlikes="3";
    String post="ggg";
    int  id= 22;
    String friendname1="youmna";
    String message="mmm";
	 UserEntity user=new UserEntity();
	      
  @Test
  public void UserEntityStringStringint() {  
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserEntity() {
   // throw new RuntimeException("Test not implemented");
  }
  @Test
  public void UserEntityStringStringString() {
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserEntityStringStringStringString() {
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserEntityStringString() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserEntityStringStringStringStringString() {
  //  throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserEntityStringStringStringStringStringString() {
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void friendname() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals(true,user.friendname());
  }

  @Test
  public void getEmail() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getEmail());
  }

  @Test
  public void getName() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getName());
  }

  @Test
  public void getPass() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getPass());
  }

  @Test
  public void getUserString() {
   // throw new RuntimeException("Test not implemented");
	 // Assert.assertEquals(true,user.getUser(json));
  }

  @Test
  public void getUserStringString() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getUser(friendname, password));
  }

  @Test
  public void getaccept() {
	// throw new RuntimeException("Test not implemented");
	//  Assert.assertEquals(true,user.getaccept(json));
  }

  @Test
  public void getcreatepage() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getcreatepage(namepage, friendname, typepage, ownerpage, numberlikes, email));
  }

  @Test
  public void getfriendString() {
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getfriendStringString() {
   // throw new RuntimeException("Test not implemented");
  }
  @Test
  public void getid() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getid());
  }

  @Test
  public void getlikepage() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getlikepage(namepage, friendname, typepage, ownerpage, numberlikes, email));
  }

  @Test
  public void getmessage() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getmessage());
  }

  @Test
  public void getmessageString() {
  //  throw new RuntimeException("Test not implemented");
	 // Assert.assertEquals(true,user.getme);
  }

  @Test
  public void getmessageStringStringStringString() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getmessage(message, friendname1, friendname, email));
  }

  @Test
  public void getmessageStringStringStringStringString() {
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getpost() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",user.getPass());
  }

  @Test
  public void getpostStringStringint() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void gettimeline() {
   // throw new RuntimeException("Test not implemented");
	 // Assert.assertEquals(true,user.gettimeline(json));
  }

  @Test
  public void saveUser() {
    //throw new RuntimeException("Test not implemented");
	  //Assert.assertEquals(true,user.saveUser());
	  Assert.assertEquals("passed", user.saveUser());
	   }

  @Test
  public void saveaccept() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.saveaccept(friendname1, friendname));
  }

  @Test
  public void savecreatepage() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savecreatepage());
  }

  @Test
  public void savefriend() {
  //  throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savefriend());
  }

  @Test
  public void savegroupmessage() {
    //throw new RuntimeException("Test not implemented");
    Assert.assertEquals("passed", user.savegroupmessage());
  }

  @Test
  public void savelikepage() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savelikepage());
  }

  @Test
  public void savemessage() {
   //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savemessage());
  }

  @Test
  public void savemessageseen() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savemessageseen());
  }

  @Test
  public void savepageliked() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.savepageliked());
  }

  @Test
  public void savepost() {
    //throw new RuntimeException("Test not implemented");
    Assert.assertEquals("passed", user.savepost());
  }

  @Test
  public void username() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", user.username());
  }
}
