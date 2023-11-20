/* 6388139  Raweebhas Paiboonwong */
package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class BoardTest {
    private Board board;
    private Square[][] grid;

    @BeforeEach
    void setUp() {
        grid = new Square[][] {
            { new BasicSquare() }
        };
        board = new Board(grid);
    }
    @Test
    void testBoardCreation() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        Board board = new Board(grid);

        assertThat(board.invariant()).isTrue();

        assertThat(board.squareAt(0, 0)).isInstanceOf(BasicSquare.class);
    }
    @Test
    void testBoardDimensions() {
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.getWidth()).isEqualTo(1);
        //assertThat(board.getWidth()).isNull();
        //for fail
        //assertThat(board.getHeight()).isEqualTo(0);
        //assertThat(board.getWidth()).isEqualTo(0);
    }
    @Test
    public void testGetWidth() {
        assertThat(board.getWidth()).isEqualTo(1);
    }

    @Test
    public void testGetHeight() {
        assertThat(board.getHeight()).isEqualTo(1);
    }

    @Test
    void testSquareAt() {
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
        assertThat(square instanceof  BasicSquare).isTrue();
    }
    @Test
    public void testWithinBorders() {
        assertThat(board.withinBorders(0, 0)).isTrue();
        assertThat(board.withinBorders(1, 0)).isFalse();
        assertThat(board.withinBorders(0, 1)).isFalse();
    }
}
