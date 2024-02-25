public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Methods for placing markers, checking win, draw, etc.
    public void printBoard(){
        for(int i = 0 ; i<3;i++)
        {
            System.out.println("--------------");
            System.out.println("| "+board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
        }
    }
    public boolean placeMarker(int row , int col , char currentPlayer){
        if (row > 2 || row < 0)
        {
            throw new RuntimeException("Row Not valid");
        }
        if(col >2 || col < 0)
        {
            throw new RuntimeException("Col Not valid");
        }
        if(board[row][col]=='-'){
            board[row][col]=currentPlayer;
            return true;
        }
        //throw exception if thw cell is already written on
        else throw new RuntimeException("Cell is already Written");
    }

    public boolean hasWinner(char currentPlayer) {
        // Check row
        for(int row = 0;row<3;row++){
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                return true;
        }
        // Check column
        for(int col = 0;col<3;col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                return true;
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}

