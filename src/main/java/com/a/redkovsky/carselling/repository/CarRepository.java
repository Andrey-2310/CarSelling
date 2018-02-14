package com.a.redkovsky.carselling.repository;

import com.a.redkovsky.carselling.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Transactional
    void deleteById(Long id);
}
