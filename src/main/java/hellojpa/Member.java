package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // JPA가 관리할 객체
public class Member {
    @Id // 데이터베이스 PK와 매핑
    private Long id;
    private String name;

    public Member() { // JPA는 기본 생성자가 있어야 한다, 꼭 public으로 할 필요 없다.(public 또는 protected)
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
