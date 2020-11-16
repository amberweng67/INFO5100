import java.util.*;



/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think.
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
    private static ArrayList<Integer> playerPositions = new ArrayList<>();
    private static ArrayList<Integer> cpuPositions = new ArrayList<>();
    private static int[] rows = new int[3];
    private static int[] cols = new int[3];
    private static int diagonal;
    private static int antiDiagonal;

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);


        while (true) {
            int steps = playerPositions.size() + cpuPositions.size();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            placePiece(gameBoard, playerPos, "player");
            if (steps + 1 == playerPositions.size() + cpuPositions.size()) {
                if (checkWinner() != null) {
                    break;
                }
                if (playerPositions.size() + cpuPositions.size() == 9) {
                    System.out.println("CAT!");
                    break;
                }
                cpuPlacePiece(gameBoard);
                if (checkWinner() != null) {
                    break;
                }
            }
            printGameBoard(gameBoard);
        }
    }

    private static void cpuPlacePiece(char[][] gameBoard) {
        ArrayList<Integer> emptyPos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j =0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    int row = i / 2;
                    int col = j / 2;
                    emptyPos.add(row * 3 + col + 1);
                }
            }
        }
        Random rand = new Random();
        int index = rand.nextInt(emptyPos.size());
        placePiece(gameBoard, emptyPos.get(index), "cpu");
    }

    public static void printGameBoard(char[][] gameBoard) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : gameBoard) {
            for (char pos : row) {
                sb.append(pos);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        int rowIndex = (pos - 1) / 3;
        int row = rowIndex + rowIndex % 3;
        int colIndex = (pos - 1) % 3;
        int col = colIndex +  colIndex % 3;
        if (gameBoard[row][col] == ' ') {
            gameBoard[row][col] = symbol;
            int toAdd = user.equals("player") ? 1 : -1;
            rows[rowIndex] += toAdd;
            cols[colIndex] += toAdd;
            if (rowIndex == colIndex) {
                diagonal += toAdd;
            }
            if (rowIndex == 3 - colIndex - 1) {
                antiDiagonal += toAdd;
            }
        } else {
            if (user.equals("player")) {
                playerPositions.remove(playerPositions.size() - 1);
            } else {
                cpuPositions.remove(cpuPositions.size() - 1);
            }
        }
    }

    private static String checkWinner(int count) {
        if (count == 3) {
            System.out.println("Congratulations you won!");
            return "player";
        } else if (count == -3) {
            System.out.println("CPU wins! Sorry:(");
            return "cpu";
        }
        return null;
    }

    public static String checkWinner() {
        String winner = null;
        for (int row : rows) {
            winner = checkWinner(row);
            if (winner != null) {
                return winner;
            }
        }

        for (int col : cols) {
            winner = checkWinner(col);
            if (winner != null) {
                return winner;
            }
        }

        winner = checkWinner(diagonal);
        if (winner != null) {
            return winner;
        }

        winner = checkWinner(antiDiagonal);
        if (winner != null) {
            return winner;
        }

        return null;
    }
}









