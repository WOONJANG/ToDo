package com.jnagwoon0518.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// Entity를 별도로 생성하지 않는 클래스
@MappedSuperclass
// Jpa를 감시하고 있다가 동작하도록 설정
@EntityListeners(value= {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    // 데이터 삽입 날짜
    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate;
    
    // 데이터 최근 수정 날짜
    @LastModifiedDate
    @Column(name="moddate")
    private LocalDateTime modDate;
}
