package com.jnagwoon0518.todo;

import com.jnagwoon0518.todo.entity.ToDo;
import com.jnagwoon0518.todo.persistence.ToDoRepository;
import com.jnagwoon0518.todo.service.ToDoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ToDoTest {
    @Autowired
    private ToDoRepository toDoRepository;
//======================================================================================================================
    // 데이터 삽입 테스트
//    @Test
    public void testInsert(){
        ToDo todo1 = ToDo.builder()
                .userId("jangwoon")
                .title("끝내주게 숨쉬기")
                .build();
        toDoRepository.save(todo1);
        ToDo todo2 = ToDo.builder()
                .userId("jangwoon")
                .title("간지나게 자기")
                .build();
        toDoRepository.save(todo2);
        ToDo todo3 = ToDo.builder()
                .userId("jangwoon")
                .title("작살나게 밥먹기")
                .build();
        toDoRepository.save(todo3);
    }
//======================================================================================================================
    // 유저 아이디를 이용한 조회
//    @Test
    public void testFindUserId(){
        List<ToDo> list = toDoRepository.findByUserId("jangwoon");

//        // 1번 방식
//        for(ToDo toDo : list){
//            System.out.println(toDo);
//        }
        
        // 2번 방식
        list.stream().forEach(toDo -> {
            System.out.println(toDo);
        });
    }
//======================================================================================================================
    // id에 해당하는 하나의 데이터 조회
//    @Test
    public void testDetail(){
        Optional<ToDo> result = toDoRepository.findById("402881c383f3825b0183f382649a0001");
        // 없는 데이터 입력해보기
//        Optional<ToDo> result = toDoRepository.findById("402881c383f3825b0183f382649a0003");
        
        if (result.isPresent()){
            System.out.println(result.get());
        }else{
            System.out.println("데이터가 존재하지 않음");
        }
    }
//======================================================================================================================
    // 데이터 수정
//    @Test
    public void testUpdate(){
        ToDo todo = ToDo.builder()
                .id("402881c383f3825b0183f382649a0001")
                .userId("장운")
                .title("화끈하게 멍 때리기")
                .build();
        toDoRepository.save(todo);
    }
//======================================================================================================================
    // 데이터 삭제
//    @Test
    public void testDelete(){
        ToDo todo = ToDo.builder()
                .id("402881c383f3825b0183f382649a0001")
                .userId("장운")
                .title("화끈하게 멍 때리기")
                .build();
        // id로 지우기
        toDoRepository.deleteById("402881c383f3825b0183f382649a0001");
    }
//======================================================================================================================
    @Autowired
    private ToDoService toDoService;

    // 삽입 테스트
//    @Test
    public void testServiceInsert(){
        ToDo toDo = ToDo.builder()
                .userId("장운")
                .title("서비스 테스트")
                .done(false)
                .build();
        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);
    }
    // 수정 테스트
//    @Test
    public void testServiceUpdate(){
        ToDo toDo = ToDo.builder()
                .id("402881c383f3825b0183f382649a0001")
                .userId("장운")
                .title("서비스 테스트")
                .done(true)
                .build();
        List<ToDo> list = toDoService.update(toDo);
        System.out.println(list);
    }

    // 삭제 테스트
//    @Test
    public void testServiceDelete(){
        ToDo toDo = ToDo.builder()
                .id("402881c383f4172e0183f41737a40000")
                .userId("장운")
                .build();
        List<ToDo> list = toDoService.delete(toDo);
        System.out.println(list);
    }

}
