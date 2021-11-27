package at.htl.josephus;

import at.htl.josephus.control.Josephusring;
import at.htl.josephus.control.Node;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JosephusringTest {

    /**
     * https://stackoverflow.com/a/62948227
     */
    @Order(10)
    @Test
    void testUuid() {
        UUID result1 = UUID.fromString("76bb18c0-86c6-446e-884d-37550247d49d");
        MockedStatic<UUID> mocked = mockStatic(UUID.class);
        mocked.when(UUID::randomUUID).thenReturn(result1);
        Josephusring r1 = new Josephusring();
        assertThat(r1.getUuid()).isEqualTo(result1);
        Josephusring r2 = new Josephusring(1,1);
        assertThat(r1.getUuid()).isEqualTo(result1);
    }

    @Order(100)
    @Test
    void createRingWith4() {
        Josephusring josephusring = new Josephusring(4, 3);
        System.out.println(josephusring);
        //assertThat(josephusring.toString()).isEqualTo("A - B - C - D");
        assertThat(josephusring.toString()).isEqualTo("A (0) - B (1) - C (2) - D (3)");
    }

    @Order(110)
    @Test
    void createRingWith3() {
        Josephusring josephusring = new Josephusring(3, 3);
        System.out.println(josephusring);
        //assertThat(josephusring.toString()).isEqualTo("A - B - C");
        assertThat(josephusring.toString()).isEqualTo("A (0) - B (1) - C (2)");
    }

    @Order(120)
    @Test
    void createRingWith2() {
        Josephusring josephusring = new Josephusring(2, 3);
        System.out.println(josephusring);
        //assertThat(josephusring.toString()).isEqualTo("A - B");
        assertThat(josephusring.toString()).isEqualTo("A (0) - B (1)");
    }

    @Order(130)
    @Test
    void createRingWith1() {
        Josephusring josephusring = new Josephusring(1, 3);
        System.out.println(josephusring);
        //assertThat(josephusring.toString()).isEqualTo("A");
        assertThat(josephusring.toString()).isEqualTo("A (0)");
    }

    @Order(140)
    @Test
    void createRingWith0() {
        Josephusring josephusring = new Josephusring(0, 3);
        System.out.println(josephusring);
        assertThat(josephusring.toString()).isEqualTo("empty ring");
    }

    @Order(150)
    @Test
    void createRingWith1and1() {
        Josephusring josephusring = new Josephusring(1, 1);
        System.out.println(josephusring);
        //assertThat(josephusring.toString()).isEqualTo("A");
        assertThat(josephusring.toString()).isEqualTo("A (0)");
    }

    @Order(200)
    @Test
    void findLastPersonWith4and3() {
        Josephusring ring = new Josephusring(4, 3);
        Node n = ring.findLastPerson();
        System.out.println(n.getPerson().toString());
        assertThat(n.getPerson().getName()).isEqualTo("A");
    }

    @Order(210)
    @Test
    void findLastPersonWith1and1() {
        Josephusring ring = new Josephusring(1, 1);
        Node n = ring.findLastPerson();
        System.out.println(n.getPerson().toString());
        assertThat(n.getPerson().getName()).isEqualTo("A");
    }

    @Order(220)
    @Test
    void findLastPersonWith10and4() {
        Josephusring ring = new Josephusring(10, 4);
        Node n = ring.findLastPerson();
        System.out.println(n.getPerson().toString());
        assertThat(n.getPerson().getName()).isEqualTo("E");
    }

    @Order(230)
    @Test
    void findLastPersonWith100and7() {
        Josephusring ring = new Josephusring(100, 7);
        Node n = ring.findLastPerson();
        System.out.println(n.getPerson().toString());
        assertThat(n.getPerson().getName()).isEqualTo("O");
    }

    @Order(240)
    @Test
    void findLastPersonWith10and10() {
        Josephusring ring = new Josephusring(10, 10);
        Node n = ring.findLastPerson();
        System.out.println(n.getPerson().toString());
        assertThat(n.getPerson().getName()).isEqualTo("H");
    }


}