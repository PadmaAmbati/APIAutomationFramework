package resources;

import java.util.ArrayList;

import pojo.AddPlacePojoClass;
import pojo.LocationPojo;

public class TestDataBuilder {

	
	public AddPlacePojoClass appplacePayload(String name, String address, String language){
		
		AddPlacePojoClass addplace=new AddPlacePojoClass();
		addplace.setAccuracy(50);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setName(name);
		addplace.setPhone_number("8124982298");
		addplace.setWebsite("http://google.com");
		LocationPojo l=new LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		ArrayList<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		addplace.setTypes(types);
		return addplace;
	}
	
	public String deletePayload(String place_id){
		return "{\r\n" + 
				"\"place_id\":\""+place_id+"\"\r\n" + 
				"}";
	}
}
