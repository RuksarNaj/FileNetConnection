package com.eb.conn;

import java.io.IOException;

import javax.security.auth.Subject;

import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;

public class FileNetConnection 
{
	public static void getConnection()throws IOException {
		ObjectStore ob="";
		String url = "http://192.168.2.203:9080/wsi/FNCEWS40MTOM/";
		String username = "deadmin";
		String password = "deadmin";
		
		Connection conn = Factory.Connection.getConnection(url);
		Subject subject = UserContext.createSubject(conn, username, password, null);
		UserContext.get().pushSubject(subject);
		Domain domain = Factory.Domain.fetchInstance(conn, null, null);
		ObjectStore objStore = Factory.ObjectStore.fetchInstance(domain, "docs", null);
		System.out.println("Object Store -->"+objStore);
		System.out.println("Connection Sucessfully");


	}
    public static void main( String[] args ) throws IOException
    {
    	getConnection();
    }
}
