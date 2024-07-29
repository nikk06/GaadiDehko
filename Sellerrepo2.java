package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Sellerrepo2 extends JpaRepository<Model5, Long>{
	//@Query(value = "SELECT s FROM Model6 s WHERE s.Okey=:Okey")
	// List<Model6> findAllByOkey(@Param("Okey") String okey);
	
	@Query(value="SELECT s FROM Model5 s WHERE s.Ycity=:Ycity AND s.Ystate=:Ystate")
	List<Model5> findAllByYcityAndYstate(@Param("Ycity")String ycity,@Param("Ystate")String ystate);
}
