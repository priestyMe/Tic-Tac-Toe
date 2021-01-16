package tictactoe;

import java.util.Scanner;

public class Main {

    private static int xCount = 0;
    private static int oCount = 0;
    private static int emptyCells = 0;

    private static char[] characters = new char[9];
    private static char[][] tictac = new char[3][3];
    private static char[][] emptyTictac = new char[3][3];

    private static int coord1 = 0;
    private static int coord2 = 0;

    public static void main(String[] args) {
        // write your code here
        int count = 0;
        //int coord1 = 0, coord2 = 0;
//
//        //read the characters as String
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter cells: ");
//        String theString = sc.next();
//
//        //decompose the string into char array
//        for(int i = 0; i < theString.length(); i++) {
//            characters [i] = theString.charAt(i);
//        }

//        //transpose the char array into a 3X3 matrix
//        int charCount = 0;
//        for (int i = 0; i < characters.length / tictac.length; i++) {
//            for (int j = 0; j < characters.length / tictac.length; j++) {
//                tictac[i][j] = characters[charCount];
//
//                if (characters[charCount] == 'X') {
//                    xCount++;
//                } else if (characters[charCount] == 'O') {
//                    oCount++;
//                } else if (characters[charCount] == ' ' || characters[charCount] == '_') {
//                    emptyCells++;
//                }
//                charCount++;
//            }
//        }

//        //print the cells
//        System.out.println("---------");
//
//        for (int i = 0; i < characters.length; i++) {
//            if (i % 3 == 0) {
//                if (i == 3 || i == 6) {
//                    System.out.println();
//                }
//                System.out.print("| ");
//            }
//
//            System.out.print(characters[i] + " ");
//
//            if (i == 2 || i == 5 ) {
//                System.out.print("| \n");
//            }
//
//            if (i + 1 == 9) {
//                System.out.println("| \n ---------");
//            }
//        }

        fillEmptyMatrix(emptyTictac);

        gameLoop();

    }

    public static boolean checkXWin (char[][] matrix) {

        return (matrix[0][0] == 'X' && matrix[0][1] == 'X' && matrix[0][2] == 'X') ||
                (matrix[1][0] == 'X' && matrix[1][1] == 'X' && matrix[1][2] == 'X') ||
                (matrix[2][0] == 'X' && matrix[2][1] == 'X' && matrix[2][2] == 'X') ||
                (matrix[0][0] == 'X' && matrix[1][0] == 'X' && matrix[2][0] == 'X') ||
                (matrix[0][1] == 'X' && matrix[1][1] == 'X' && matrix[2][1] == 'X') ||
                (matrix[0][2] == 'X' && matrix[1][2] == 'X' && matrix[2][2] == 'X') ||
                (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') ||
                (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X');
    }

    public static boolean checkOWin (char[][] matrix) {

        return (matrix[0][0] == 'O' && matrix[0][1] == 'O' && matrix[0][2] == 'O') ||
                (matrix[1][0] == 'O' && matrix[1][1] == 'O' && matrix[1][2] == 'O') ||
                (matrix[2][0] == 'O' && matrix[2][1] == 'O' && matrix[2][2] == 'O') ||
                (matrix[0][0] == 'O' && matrix[1][0] == 'O' && matrix[2][0] == 'O') ||
                (matrix[0][1] == 'O' && matrix[1][1] == 'O' && matrix[2][1] == 'O') ||
                (matrix[0][2] == 'O' && matrix[1][2] == 'O' && matrix[2][2] == 'O') ||
                (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') ||
                (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O');
    }

    public static boolean checkDraw (char[][] matrix) {

        if (!checkOWin(matrix) && !checkXWin(matrix) && (xCount + oCount == matrix.length)) {
            {
                return true;
            }
        }

        return false;
    }

    public static boolean gameNotFinished (char[][] matrix) {

        if (!checkOWin(matrix) && !checkXWin(matrix) && (emptyCells > 0)) {
            {
                return true;
            }
        }

        return false;
    }

    public static void requestUserMove(char[][] matrix) {

        Scanner sc = new Scanner(System.in);

        boolean validEntry = false;
        do {
            System.out.println("Enter the coordinates: ");
            while (!sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
                sc.next(); // this is important!
            }

            coord1 = sc.nextInt();
            coord2 = sc.nextInt();

            if((coord1 > 0 && coord1 < 4) && (coord2 > 0 && coord2 < 4)) {
                validEntry = true;
            }
            else {
                System.out.println("Coordinates should be from 1 to 3!");
                validEntry = false;
                continue;
            }

            if ((matrix[coord1 - 1][coord2 - 1] == 'X') || (matrix[coord1 - 1][coord2 - 1] == 'O')){

                System.out.println("This cell is occupied! Choose another one!");
                validEntry = false;
            }
        } while (!validEntry);


    }

    public static void printMatrix(char[][] matrix)
    {
        System.out.println("---------");

        for (char[] chars : matrix) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.print("| \n");
        }

        System.out.println("---------");
    }

    public static void fillEmptyMatrix (char[][] matrix) {

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                chars[j] = ' ';
            }
        }

    }

    public static void countXY (char[][] matrix) {

        int count = 0;

        xCount = 0;
        oCount = 0;
        emptyCells = 0;

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (chars[j] == 'X') {
                    xCount++;
                } else if (chars[j] == 'O') {
                    oCount++;
                } else {
                    emptyCells++;
                }
            }
        }

    }

    public static void gameLoop() {

        boolean played = true;

        do {

            printMatrix(emptyTictac);

            requestUserMove(emptyTictac);

            if (played) {
                emptyTictac[coord1-1][coord2-1] = 'X';
                played = !played;
            } else {
                emptyTictac[coord1-1][coord2-1] = 'O';
                played = !played;
            }

            printMatrix(emptyTictac);

            countXY(emptyTictac);

            if (!gameNotFinished(emptyTictac)) {
                checkGameStatus(emptyTictac);
            }

        } while (gameNotFinished(emptyTictac));
    }

    public static void checkGameStatus (char[][] matrix) {

        //countXY(matrix);

        if (Math.abs(xCount - oCount) > 1)
        {
            System.out.println("Impossible");
        } else if (checkXWin(matrix) && xCount >= oCount)
        {
            if (checkOWin(matrix)) {
                System.out.println("Impossible");
            } else {
                System.out.println("X wins");
            }
        } else if (checkOWin(matrix) && oCount >= xCount)
        {
            if (checkXWin(matrix)) {
                System.out.println("Impossible");
            } else {
                System.out.println("O wins");
            }
        } else if (!checkOWin(matrix) && !checkXWin(matrix) && emptyCells == 0)
        {
            System.out.println("Draw");
        } else if (!checkOWin(matrix) && !checkXWin(matrix) && emptyCells > 0)
        {
            System.out.println("Game not finished");
        } else
        {
            System.out.println("Impossible");
        }

    }

}
