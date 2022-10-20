package com.jnagwoon0518.todo.service;

import com.jnagwoon0518.todo.entity.ToDo;
import com.jnagwoon0518.todo.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;

    private void validate(final ToDo toDo){
        if(toDo == null){
            throw new RuntimeException("ToDo cannot be null");
        }
        if(toDo.getUserId() == null){
            throw new RuntimeException("UerId cannot be null");
        }
    }

    @Override
    public List<ToDo> create(ToDo toDo) {
        validate(toDo);
        // 데이터 추가
        toDoRepository.save(toDo);
        // 데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> retrieve(String userId) {
        return toDoRepository.findByUserId(userId);
    }

    @Override
    public List<ToDo> update(ToDo toDo) {
        validate(toDo);
        // 데이터 추가
        toDoRepository.save(toDo);
        // 데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> delete(ToDo toDo) {
        validate(toDo);
        // 데이터 추가
        toDoRepository.delete(toDo);
        // 데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }
}
