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
public interface Buyerreqrepo extends JpaRepository<Model10, Long>{
	@Query(value="SELECT s FROM Model10 s WHERE s.Bstate=:Bstate")
	List<Model10> findAllByBstate(@Param("Bstate") String bstate);
	
	
	@Query(value="SELECT s FROM Model10 s WHERE s.Bmail=:Bmail")
	List<Model10> findAllByBmail(@Param("Bmail")String bmail);
	
	  @Transactional
	 @Modifying
	 @Query("DELETE FROM Model10 s WHERE s.Bmail=:Bmail")
	  void deleteByBmail(@Param("Bmail")String bmail);
}
