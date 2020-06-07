package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	static RequestSpecification req;
	ResponseSpecification resspec;

	public RequestSpecification sepcBuilders() throws IOException{
		
		
		if(req==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		req=new RequestSpecBuilder().setBaseUri(getglobalValue("baseURI"))
			 .addQueryParam("key","qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
	
		return req;
		}
		return req;
}
	
	public static String getglobalValue(String key) throws IOException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\91812\\workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	
	}
	public String getkeyvalue(String response,String key){
		JsonPath js=new JsonPath(response);
		return js.get(key);
		
		
	}
}
