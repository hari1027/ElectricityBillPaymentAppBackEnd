package com.capgemini.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.modules.Connection;
import com.capgemini.modules.Reading;
@Repository

public interface ReadingRepository extends JpaRepository<Reading , Long> {
	@Query(value="select e from Reading e where e.readingId=?1") 
    public List<Reading> searchReadingById(@Param("readingId")Long readingId);

	@Query(value="select e from Reading e where e.readingForConnection=?1") 
	public Optional<Reading> findByconnection(Connection readingForConnection);
   
 }
