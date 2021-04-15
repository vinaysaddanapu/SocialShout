package com.example.socialshout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.socialshout.entity.Announcement;

public interface AnnouncementRepo2 extends JpaRepository<Announcement, Long> {
	
	@Query(value = "select * from Announcement a where a.title like %?1" ,nativeQuery = true)
     public List<Announcement> search(String input);
	 	
	
}
