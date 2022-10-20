package com.jnagwoon0518.todo.persistence;

import com.jnagwoon0518.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//ToDo.java 기본키의 자료형 확인 (String)
public interface ToDoRepository extends JpaRepository<ToDo, String> {
    
    // userId를 가지고 조회하는 메서드
    public List<ToDo> findByUserId(String userid);
}
