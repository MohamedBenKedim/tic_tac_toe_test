import java.util.Scanner;

public class Game {
    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
    }

    public void play() {
        while (true) {
            board.printBoard();
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
                row = new Scanner(System.in).nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = new Scanner(System.in).nextInt() - 1;
            } while (!board.placeMarker(row, col, currentPlayer));

            if (board.hasWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
