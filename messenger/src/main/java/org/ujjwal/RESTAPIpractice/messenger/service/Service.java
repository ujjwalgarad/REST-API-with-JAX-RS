package org.ujjwal.RESTAPIpractice.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.ujjwal.RESTAPIpractice.messenger.database.DatabaseClass;
import org.ujjwal.RESTAPIpractice.messenger.exception.DataNotFoundException;
import org.ujjwal.RESTAPIpractice.model.Message;

public class Service {
	
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public Service(){
		messages.put(1L, new Message(1, "Hello Worlds!", "Ujjwal"));
		messages.put(2L, new Message(2, "Hello Jersey!", "Garad"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMesagesForYear(int year){
			List<Message> messageForYear = new ArrayList<>();
			Calendar cal = Calendar.getInstance();
			for(Message m : messages.values()){
				cal.setTime(m.getCreated());
				if(cal.get(Calendar.YEAR) == year)
					messageForYear.add(m);
			}
			return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messageList = new ArrayList<>(messages.values());
		if(start + size > messageList.size())
			return new ArrayList<>();
		
		return messageList.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
