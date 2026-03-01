package hellojpa;

import jakarta.persistence.*;

@Entity // JPA가 관리할 객체
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Member {
    @Id // 데이터베이스 PK와 매핑
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String username;


    public Member() { // JPA는 기본 생성자가 있어야 한다, 꼭 public으로 할 필요 없다.(public 또는 protected)
    }
}
