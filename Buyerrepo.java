package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface Buyerrepo extends JpaRepository<Model8,Long> {
	 //@Query(value = "SELECT s FROM Model2 s WHERE s.Demaill=:Demaill AND s.Dpasssowrd=:Dpasssowrd") 
     //Model2 findByDemaillAndDpasssowrd(@Param("Demaill")String demaill,@Param("Dpasssowrd") String dpasssowrd);
	
	@Query(value="SELECT s FROM Model8 s WHERE s.Bemaill=:Bemaill AND s.Bpasssowrd=:Bpasssowrd")
	Model8 findByBemaillAndBpasssowrd(@Param("Bemaill") String bemaill,@Param("Bpasssowrd")String bpasssowrd);
	
	@Modifying
	 @Transactional
	 @Query("UPDATE Model8 s SET s.Bpasssowrd= ?2 WHERE s.Bemaill= ?1")
	int updatePasswordByEmaill(String Bemaill, String Bpasssowrd );
}
