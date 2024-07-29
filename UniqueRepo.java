package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface UniqueRepo extends JpaRepository<Model3,Long> {
	 @Query(value = "SELECT s FROM Model3 s WHERE s.UniqueKey=:UniqueKey") 
     Model3 findByUniqueKey(@Param("UniqueKey")String unique);
}
