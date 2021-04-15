package com.example.socialshout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.socialshout.entity.User;

@Repository("AnnouncementRepo")
public interface AnnouncementRepo extends JpaRepository<User, Long> {

	 @Query(value="select * from User u where u.email_id=?1 and u.password=?2",  nativeQuery = true)
     User findUserByNameOrPassword(String email_id, String password);
	
	 
}
