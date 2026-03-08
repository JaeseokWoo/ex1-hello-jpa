package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker") // 일대일: 대상 테이블에 외래 키 단반향 방식은 JPA 지원하지 않는다. 양방향은 지원
    private Member member;

    // 대상 테이블에 외래 키
    // 단점: 프록시 기능의 한계로 지연 로딩으로 설정해도 항상 즉시 로딩됨
}
