package com.jnagwoon0518.todo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode
@Table(name="todo")
// BaseEntity 클래스를 extends 해서 공통된 컬럼을 가져옴 ( 삽입, 마지막 수정 날짜 )
public class ToDo extends BaseEntity{
    
    // 기본 키로 사용할 ID
    // 랜덤한 UUID를 가지고 ID값을 생성
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    
    // 사용자 식별 ID
    @Column(length = 100, nullable = false)
    private String userId;
    
    // 제목
    @Column(length = 500, nullable = false)
    private String title;
    
    // 수행 여부
    @Column(nullable = false)
    private boolean done;
}
