package com.example.springboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

}
