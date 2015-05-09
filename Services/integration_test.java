package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class integration_test {
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
    /////////////////////////////////////////
    /*public void method1() {
    	System.out.println("This is method 1");
    	throw new RuntimeException();
    	}
    	@Test(dependsOnMethods = { "method1" })
    	public void method2() {
    	System.out.println("This is method 2");
    	}*/
    ///////////////////////////////
    
  public void acceptrequist() {
	  System.out.println("This is AcceptRequest");
  	throw new RuntimeException();

  }
  @Test(dependsOnMethods = { " acceptrequist" })
  public void saveaccept() {
  	System.out.println("This is SaveAccept");
  	}
  
  
  public void addfriend() {
	  System.out.println("This is AddFreiend");
	  	throw new RuntimeException();
  
  }
  @Test(dependsOnMethods = { " addfriend" })
  public void savefriend() {
  	System.out.println("This is SaveFriend");
  	}
  
  
  public void createpage() {
	  System.out.println("This is CreatePage");
	  	throw new RuntimeException();
  }

  @Test(dependsOnMethods = { " createpage" })
  public void savecreatepage() {
  	System.out.println("This is SaveCreatePage");
  	}
  

  public void createpost() {
	  System.out.println("This is CreatePost");
	  	throw new RuntimeException();
  }
  @Test(dependsOnMethods = { " createpost" })
  public void savepost() {
  	System.out.println("This is SavePost");
  	}
  

  public void groupmessage() {
	  System.out.println("This is GroupMessage");
	  	throw new RuntimeException(); 
  }
  @Test(dependsOnMethods = { " createpost" })
  public void savegroupmessage() {
  	System.out.println("This is Savegroupmessage");
  	}
  
  public void likpage() {
	  System.out.println("This is Likepage");
	  	throw new RuntimeException(); 
  }
  @Test(dependsOnMethods = { " likepage" })
  public void savepageliked() {
  	System.out.println("This is SavePageLiked");
  	}
  
  public void loginService() {
	  System.out.println("This is LoginService");
	  	throw new RuntimeException(); 
	  	}
  @Test(dependsOnMethods = { " loginService" })
  public void getuser() {
  	System.out.println("This is GetUser");
  	}
  /////////////////////

  /*public void registrationServiceStringStringString() {
    //throw new RuntimeException("Test not implemented");
	  Assert.assertEquals(true, service.registrationService(name, email, password));
  }*/
/////////////////////////////
  public void registrationService() {
	  System.out.println("This is Registration");
	  	throw new RuntimeException(); 
	  	}

  @Test(dependsOnMethods = { " registrationService" })
  public void saveUser() {
  	System.out.println("This is SaveUser");
  	}
  
  public void sendmessage() {
	  System.out.println("This is SendMessage");
	  	throw new RuntimeException();  
  }
  @Test(dependsOnMethods = { " registrationService" })
  public void savemessage () {
  	System.out.println("This is SaveMessage");
  	}
  
 /* public void signoutService() {
   // throw new RuntimeException("Test not implemented");
	  Assert.assertEquals(true, service.signoutService());
  }*/
}