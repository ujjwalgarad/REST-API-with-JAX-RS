package org.ujjwal.RESTAPIpractice.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ujjwal.RESTAPIpractice.messenger.database.DatabaseClass;
import org.ujjwal.RESTAPIpractice.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	
	public ProfileService(){
		profiles.put("ujjwal", new Profile(1L, "ujjwal", "Ujjwal", "Garad"));
		//messages.put(2L, new Message(2, "Hello Jersey!", "Garad"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
