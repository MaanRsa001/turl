package com.maan.shorturl.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository  extends JpaRepository<ShortUrlMaster, String>{
	
	@Query(value ="SELECT SHORT_ID.NEXTVAL FROM DUAL",nativeQuery=true)
	public Integer getshortId();

	public List<ShortUrlMaster> findByRequestUrlIgnoreCase(String upperCase);

}
