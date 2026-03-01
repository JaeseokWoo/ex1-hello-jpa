package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 ersistence-unit
        // EntityManagerFactory는 애플리케이션 로딩 시점에 딱 하나만 만들어야 한다.

        EntityManager em = emf.createEntityManager(); // DB 커넥션을 얻어서 쿼리를 날리고 종료되는 그런 하나의 일관적인 트랜잭션 단위를 할 때 마다 EntityManager를 만들어줘야 한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행

        try {
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            team.addMember(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
            List<Member> members = findTeam.getMembers();

            System.out.println("=====================");
            System.out.println("findTeam = " + findTeam);
            System.out.println("=====================");

            tx.commit(); // 트랜잭 커밋할 때도 자동으로 flush 호출
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // EntityManager 내부적으로 데이터베이스 커낵션을 물고 동작하기 때문에 사용을 다 하면 닫아주어야 한다.
        }

        emf.close();
    }
}
