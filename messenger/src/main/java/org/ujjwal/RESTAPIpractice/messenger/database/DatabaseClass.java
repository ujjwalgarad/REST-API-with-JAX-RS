package org.ujjwal.RESTAPIpractice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.ujjwal.RESTAPIpractice.model.Message;
import org.ujjwal.RESTAPIpractice.model.Profile;

@XmlRootElement
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
	

}
