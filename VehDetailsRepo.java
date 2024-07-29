package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@EnableJpaRepositories
public interface VehDetailsRepo extends JpaRepository<Model6,Long> {
	 @Query(value = "SELECT s FROM Model6 s WHERE s.Okey=:Okey")
	 List<Model6> findAllByOkey(@Param("Okey") String okey);
	 
	 @Transactional
	 @Modifying
	 @Query("DELETE FROM Model6 s WHERE s.Ovno=:Ovno")
	 
     void deleteByOvno(@Param("Ovno")String ovno);
}
