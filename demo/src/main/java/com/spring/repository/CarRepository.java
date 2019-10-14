package com.spring.repository;

import com.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT distinct c.mark  FROM Car c order by c.mark")
    List<String> getAllMarks();

    List<Car> findAllByMark(String mark);

    @Query("SELECT distinct c.classCar  FROM Car c order by c.classCar")
    List<String> getAllClasses();

    List<Car> findAllByClassCar(String className);

    @Query("SELECT c FROM Car c where c.name like %?1% or c.mark like %?1%")
    List<Car> getCarsBySearchQuery(String query);

    List<Car> findAllByNameContainingOrMarkContaining(String query, String s);
}