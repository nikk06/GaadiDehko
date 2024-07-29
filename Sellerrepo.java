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
public interface Sellerrepo extends JpaRepository<Model2,Long> {
	 @Query(value = "SELECT s FROM Model2 s WHERE s.Demaill=:Demaill AND s.Dpasssowrd=:Dpasssowrd") 
     Model2 findByDemaillAndDpasssowrd(@Param("Demaill")String demaill,@Param("Dpasssowrd") String dpasssowrd);
	 
	 @Modifying
	 @Transactional
	 
	    //@Query("UPDATE Model5 s SET s.Ycity = :newYcity WHERE s.Ycity = :currentYcity AND s.Ystate = :currentYstate")
	    //int updateYcityByYcityAndYstate(@Param("newYcity") String newYcity, @Param("currentYcity") String currentYcity, @Param("currentYstate") String currentYstate);
	 
          @Query("UPDATE Model2 s SET s.Dpasssowrd= ?2 WHERE s.Demaill= ?1")
	       int updatePasswordByEmail(String Demaill, String Dpasssowrd );
	 
	 
	 
}
