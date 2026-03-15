package hellojpa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn // DTYPE 필드 추가됨(가본값은 Entity 이름), InheritanceType.SINGLE_TABLE일 때는, 기본으로 DiscriminatorColumn가 들어간다.
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
