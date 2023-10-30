package com.zinco.react_back.repository;

import com.zinco.react_back.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommandRepository extends JpaRepository<Recommend, Integer> {
}
