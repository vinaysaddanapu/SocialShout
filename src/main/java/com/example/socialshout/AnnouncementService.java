package com.example.socialshout;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialshout.entity.Announcement;
import com.example.socialshout.entity.User;
import com.example.socialshout.repository.AnnouncementRepo;
import com.example.socialshout.repository.AnnouncementRepo2;

@Service
public class AnnouncementService {
	
	@Autowired
	AnnouncementRepo  announcementRepo;
	
	@Autowired
	AnnouncementRepo2 postRepo;
	
	
	public AnnouncementService() {
		  System.out.println("Service Layer is created");
		  
	  }
	  
	  // Get single user
	  public User findUser(Login login) {
		  
		   String uname = login.getEmail_id();
		   String pass =  login.getPassword();
		   
		   
		User user  = announcementRepo.findUserByNameOrPassword(uname,pass);
		
		if(user != null) {
		if(user.getEmail_id().equals(login.getEmail_id())&& user.getPassword().equals(login.getPassword())) {
			System.out.println("Login success");
			System.out.println(user);
		}else {
           
			System.out.println("Login failed");
				
		}
			}
		
		return user;
		     
	  }

	  
	  // get All users
	  public List<User> findUsers() {
		  List<User> users = announcementRepo.findAll();
		  return users;
		  
	  }
	  
	    // Register the user
	     public User register(User user) {
	    	 
	    	 return announcementRepo.save(user);

		}        

	 
	// Post Announcement  
	public Announcement addAnnouncement(Announcement announcement) {
		
		Date date = new Date();
		String currentDate = date.toString();
		announcement.setDate(currentDate);
	  
		return postRepo.save(announcement);
	}
	
	
	// Get All Announcements
	public List<Announcement> findAnnouncements() {
		
		List<Announcement> announcements = postRepo.findAll();
		
		return announcements;   
		
	}
	

      // Delete Announcement
	public Announcement deleteAnnouncement(Long id) {
		
		Announcement announcementDelete = postRepo.getOne(id);
		postRepo.delete(announcementDelete);
		return announcementDelete;
		
	}
	
	//Update Announcement
	public Announcement updateAnnouncement(Announcement announcement) {
		
		return postRepo.save(announcement);
	}


	// Get Single Announcement
     public Announcement getAnnouncement(Long id) {
    	 
    	 Announcement foundAnnouncement = postRepo.getOne(id);
    	 return foundAnnouncement;
    	
     }
     
     
     //Search Announcement
     public List<Announcement> search(String input) {
    	 
     List<Announcement> searchedAnnouncement = (List<Announcement>) postRepo.search(input);
     return searchedAnnouncement;
   	 
     }
     
     // Get image by id
     public List<Announcement> getPhotoById(Long id){
 
     List<Announcement>  images = postRepo.findAll();
     return images;
  	
	}
     
     
     // Get Single User
    public User profile(Long id) {
    	
    	User foundUser = announcementRepo.getOne(id);
    	return foundUser;
		
	}
    
    
    
    //Map User
    public Map<String,List<User>> getUsersByKey() {
    	
    	Map<String,List<User>>userMap = new HashMap<>();
    	
    	 List<User> users = announcementRepo.findAll();
    	
    	    for (User user : users) {
    	    	System.out.println(user);
    	    	if(userMap.get(user.getName()) != null) {
    	    		userMap.get(user.getName()).add(user);
    	    	
			   }else {
				   List<User> newUser = new ArrayList<>();
				   newUser.add(user);
				   userMap.put(user.getName(), newUser);
			   }
    	    }
    	
            return userMap;
		
	}
     

}
