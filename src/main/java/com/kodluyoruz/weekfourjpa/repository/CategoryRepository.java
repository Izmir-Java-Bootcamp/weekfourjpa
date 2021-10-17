package com.kodluyoruz.weekfourjpa.repository;

import com.kodluyoruz.weekfourjpa.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
