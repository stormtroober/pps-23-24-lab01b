package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private Logics logic;
  private static final int SIZE = 5;

  @BeforeEach
  void createBoard(){
    this.logic = new LogicsImpl(SIZE, new Pair<Integer,Integer>(1, 1),
                           new Pair<Integer,Integer>(2, 3));
  }

  @Test
  @Timeout(30)
  void isKnightInTheBoard(){
    assertNotNull(logic.getKnightPosition());
  }

  @Test
  @Timeout(30)
  void isPawnInTheBoard(){
    assertNotNull(logic.getPawnPosition());
  }

  @Test
  @Timeout(30)
  void moveKnightIntoPawn(){
    assertTrue(logic.hit(logic.getPawnPosition().getX(), logic.getPawnPosition().getY()));
  }


  @Test
  void moveKnightInBoard(){
    var newPosition = new Pair<Integer, Integer>(logic.getPawnPosition().getX()-1,
                                                 logic.getPawnPosition().getY()+1);
    logic.hit(newPosition.getX(), newPosition.getY());
    assertEquals(logic.getKnightPosition(), newPosition);
  }

  @Test
  void moveKnightOutOfBoard(){
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-1, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(SIZE, SIZE));
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(SIZE, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-1, SIZE));
  }

}
