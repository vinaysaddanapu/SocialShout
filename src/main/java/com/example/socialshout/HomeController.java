package com.example.socialshout;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.socialshout.entity.Announcement;
import com.example.socialshout.entity.User;

@RestController
public class HomeController {
	
	@Autowired
	AnnouncementService announcementService;
	
	static Long myId;
	
	
    @RequestMapping("/")
    @ResponseBody
	public ModelAndView welcome() {
		
    	ModelAndView andView = new ModelAndView();
    	andView.setViewName("home");
    	return andView;
    	
		
	}
    
    @GetMapping(path="/users")
	public List<User> getUser(){
		
		List<User> users =  announcementService.findUsers();
		 return users;
		
		
	}
    
    @PostMapping(path = "/register")
    public ModelAndView register(@RequestParam("name") String name, @RequestParam("email_id") String email_id, @RequestParam("password") String password) {
    	
    	ModelAndView view = new ModelAndView();
    	User user = new User();
    	 
    	user.setName(name);
    	user.setEmail_id(email_id);
    	user.setPassword(password);
  
    	User registeredUser  = announcementService.register(user);
    	
    	view.addObject("login", registeredUser);
    	view.setViewName("main");
    	return view;
		
	}
    
    
    @GetMapping(path = "/getAnnouncements")
   	public ModelAndView getAnnouncements() {
    	
   		ModelAndView view = new ModelAndView();
   		List<Announcement> announcements  =  announcementService.findAnnouncements();
   		view.addObject("announcements", announcements);
   		view.setViewName("list");
   		return view;
   		
   		
   	}
    
  
	@PostMapping(path="/login")
    public ModelAndView login(@RequestParam("email_id") String email_id, @RequestParam("password") String password, HttpServletRequest request) {
    	
		HttpSession session = request.getSession();
		
		Login login = new Login();
		login.setEmail_id(email_id);
		login.setPassword(password);
		
        User login2 = (User) announcementService.findUser(login);
           
        ModelAndView andView = new ModelAndView();
         if(login2 != null) {
        	   andView.addObject("login",login2);
        	   andView.setViewName("main");
        	   session.setAttribute("authorized", "yes");
        	   return andView;
        	   
           }else {
        	   String msg = "Enter Correct username and password";
        	   andView.addObject("msg", msg);
        	   andView.setViewName("home");
		       return andView;
    	
    }
	}
	
	
	@PostMapping(path = "/announce")
	public Announcement postAnnouncement(@RequestParam("title") String title, @RequestParam("subject") String subject,
			@RequestParam("desc") String desc, @RequestParam("image") MultipartFile image) throws IOException{
		
		Announcement announcement = new Announcement();
		announcement.setTitle(title);
		announcement.setDescription(desc);
		announcement.setSubject(subject);
		
		byte[] getImage  = image.getBytes();
		announcement.setImage(getImage);

		return announcementService.addAnnouncement(announcement);
	
	
	}
	
	
  
    @GetMapping(path = "/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
    	
            
         announcementService.deleteAnnouncement(id);
         return "Deleted successfully";
         
         
    }
    
    @RequestMapping(value="/update/{id}")
    public void getId(@PathVariable("id") Long id, HttpServletResponse response) throws IOException{
    
        System.out.println(id);
         myId = id;
       
         Announcement displayAnnouncement = announcementService.getAnnouncement(id);
        // view.addObject("ann2", displayAnnouncement);
       
         response.sendRedirect("/update.jsp");
        
    }
    
    
    @PostMapping(path="/update")
    public Announcement updatePost(@RequestParam("title") String title, @RequestParam("subject") String subject, @RequestParam("desc") String desc) {
    	
         Announcement announcement = announcementService.getAnnouncement(myId);
         
         announcement.setTitle(title);
         announcement.setSubject(subject);
         announcement.setDescription(desc);
       
       return  announcementService.updateAnnouncement(announcement);
        
       	
    }
    
    
    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") String searchInput){
    	
    	ModelAndView view =  new ModelAndView();
    	if(searchInput.equals("")) {
            
    		view.addObject("errorMsg", "Please Enter the text");
    		view.setViewName("search");
    		return view; 
    		
    	}else {	
    	List<Announcement> searchedAnnouncement  =  (List<Announcement>)announcementService.search(searchInput);	
    	view.addObject("searchedAnnouncement",searchedAnnouncement);
    	view.setViewName("search");
    	return view;
    	
    	}
   	                        	
    }
    
    
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
    	
    	ModelAndView andView = new ModelAndView();
    	session.removeAttribute("authorized");
    	session.invalidate();
    	andView.setViewName("home");
    	
    	return andView;
    }
    
    
    @GetMapping(path = "/getPhoto/{id}" )
    public void getPhotoById(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
    	
     System.out.println(id);          
    	
     Announcement ann = announcementService.getAnnouncement(id); 	
     response.getOutputStream().write(ann.getImage());
      
		
	}
    
    @GetMapping(path = "/profile/{id}")
    public ModelAndView profile(@PathVariable("id") Long id) {
    	
    	System.out.println("Profile id:" + id);
    	
     	ModelAndView andView = new ModelAndView("/profile");
        User profile = announcementService.profile(id);
        andView.addObject("profile", profile);
        return andView;
       
      
     
		
	}
    
    
    @GetMapping("/getUsersByKey")
    public Map<String, List<User>> userByMap() {
    	
    	Map<String, List<User>> map = new HashMap<String,List<User>>();
    	
    	 map = announcementService.getUsersByKey();
    	 
    	 return map;
		
	}
    

}
