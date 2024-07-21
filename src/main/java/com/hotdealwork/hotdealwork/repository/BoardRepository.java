package com.hotdealwork.hotdealwork.repository;


import com.hotdealwork.hotdealwork.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
