package com.jumpstart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Category;
import com.jumpstart.store.entity.Chart;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    

}
