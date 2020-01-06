package demo;

import java.util.TreeMap;

import com.testpro.util.App;



public class AES {

	
	 public static final String serverPrivateKey =
		      "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvFHnIf+gSz9Br9aWRA8jLj7OymuZUsBQffzsrPNebyVIvyUUSj3LxQiAFDhIJtRnXw9rtaY04XYIQVGoWwho9L+2/1WohyCEg+5z7WZoEFb/JnHfCoFUHdIFH5aLvpz8/52Ofrh4LT529TBFTaNWTxMsgDlTjUMC/xrKZ8aL41zeOt0IhiNpMuI1JIH8BAh7zGI/7l2y7fBap7n0hBerc+m3IC/jqBjl3Nde/OoV6WA4CuEInVwLaIyWFo35tjHgVvfkUHHf8lBOpTQOWegZofjMEmUpahBPf/WCvbohvMIbyb4d6fgAEQKllxma3fLskVS2caUCJIoAPAqfGWlwuQIDAQAB";

	public static void main(String[] args) {
		
		   App app = new App(); //
		    TreeMap<String, Object> params = new TreeMap<String, Object>();
		    params.put("userid", "32432");
		    params.put("phone1", "32432");
		    final String appValue = app.getEncryptString(serverPrivateKey, params, "张三");
		    System.out.println(appValue);
		    String  s=app.getPublicmapkey();
		
	}
}
