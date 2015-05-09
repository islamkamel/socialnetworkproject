package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ServiceTest {
	Service service=new Service();
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
  public void acceptrequist() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",service.acceptrequist(friendname,name));
  }
  public void addfriend() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",service.addfriend(friendname,name));
  }

  public void createpage() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed",service.createpage(namepage, friendname, typepage, ownerpage, numberlikes, email));
  }

  public void createpost() {
  //  throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.createpost(post, friendname, id));
  }

  public void groupmessage() {
   
	  // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.groupmessage(friendname, friendname1, friendname, message, email));
  }

  public void likpage() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.likpage());
  }

  public void loginService() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.loginService(name, password));
  }

  public void notification() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.notification());
  }

  public void registrationServiceStringStringString() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.registrationService(name, email, password));
  }

  public void registrationService() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.registrationService(name, email, password));
  }

  public void sendmessage() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.sendmessage(friendname1, friendname, message, email));
  }

  public void signoutService() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals("passed", service.signoutService());
  }
}
