package com.jnagwoon0518.todo.controller;

import com.jnagwoon0518.todo.domain.ResponseDTO;
import com.jnagwoon0518.todo.domain.ToDoDTO;
import com.jnagwoon0518.todo.entity.ToDo;
import com.jnagwoon0518.todo.service.ToDoService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;

    // 데이터 삽입
    // http://localhost/todo 에 POST 방식으로 title만 태워 보내기 (POSTMAN)
    @PostMapping()
    public ResponseEntity<?> createToDo(@RequestBody ToDoDTO dto){
        try{
            // 가상의 USER-ID 생성
            String temporaryUserId = "COSMOS";

            // Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            // 데이터 생성
            List<ToDo> entities = toDoService.create(toDo);

            // ToDoDTO 의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new)
                    .collect(Collectors.toList());

            // 응답 객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retriveToDoList(){
        // 임시 ID
        String temporaryUserId = "COSMOS";
    
        // 임시 ID로 데이터 찾아오기
        List<ToDo> entities = toDoService.retrieve(temporaryUserId);
        
        // 찾아 온 데이터를 이용해서 DTO의 List 만들기
        List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new)
                .collect(Collectors.toList());

        // 응답 객체 생성
        ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                .data(dtos)
                .build();
        // 클라이언트에게 전송
        return ResponseEntity.ok().body(response);
    }

    // 데이터 수정
    // http://localhost/todo 에 PUT 방식으로 id, title, done 설정
    @PutMapping()
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO dto){
        try{
            // 가상의 USER-ID 생성
            String temporaryUserId = "COSMOS";

            // Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            // 데이터 생성
            List<ToDo> entities = toDoService.update(toDo);

            // ToDoDTO 의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new)
                    .collect(Collectors.toList());

            // 응답 객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    // 데이터 삭제
    // http://localhost/todo 에 DELETE 방식으로 id, title, done 설정
    @DeleteMapping()
    public ResponseEntity<?> deleteToDo(@RequestBody ToDoDTO dto){
        try{
            // 가상의 USER-ID 생성
            String temporaryUserId = "COSMOS";

            // Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            // 데이터 생성
            List<ToDo> entities = toDoService.delete(toDo);

            // ToDoDTO 의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new)
                    .collect(Collectors.toList());

            // 응답 객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
