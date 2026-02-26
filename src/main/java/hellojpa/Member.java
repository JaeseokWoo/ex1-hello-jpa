package hellojpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 관리할 객체
public class Member {
    @Id // 데이터베이스 PK와 매핑
    private Long id;

    @Column(name = "name")
    private String username;

    private BigDecimal age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDatetime;

    @Lob
    private String description;

    @Transient
    private int temp;

    public Member() { // JPA는 기본 생성자가 있어야 한다, 꼭 public으로 할 필요 없다.(public 또는 protected)
    }
}
