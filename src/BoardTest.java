import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class BoardTest {
    Board board;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
    board = new Board();
    }

    @Test
    public void placeMarker() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Cell is already Written");
        board.placeMarker(2,2,'X');
        board.placeMarker(2,2,'Y');
    }

    @Test
    public void WhenRowEntryNotValid() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Row Not valid");
        board.placeMarker(4,2,'X');
    }

    @Test
    public void WhenColEntryNotValid() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Col Not valid");
        board.placeMarker(1,7,'X');
    }

}