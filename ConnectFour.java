import java.util.Scanner;

public class ConnectFour {
    //print board method
    public static void printBoard(char[][]array){
        for(int i = array.length-1; i>=0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    //initialize board method
    public static void initializeBoard(char[][]array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = '-';
        }

    }
    //insert chip method
    public static int insertChip(char[][]array, int col, char chipType) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                return i;
            }
        }
        return -1;
    }
    //check winner method
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else{
                count =0;
            }
        }
            for (int j = 0; j<array[0].length; j++) {
                if (array[row][j] == chipType) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else{
                    count = 0;
                }
            }



      return false;
    }
    //check tie method
    public static boolean checkIfTie(char[][] array, int col, int row, char chipType){
        for(int i = array.length-1; i>=0; i--) {
            for (int j = 0; j < array[i].length; j++) {
               if (array[i][j] == '-'){
                   return false;

               }
            }
        }

        return true;
    }

    //beginning of main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be? ");
        int row = scanner.nextInt(); //row variable
        System.out.println("What would you like the length of the board to be? ");
        int col = scanner.nextInt(); //column variable
        char[][] board = new char[row][col]; //initialize board as a char
        boolean player = false; //variable for loop
        char chipType = 'x'; //variable for chip type
        initializeBoard(board);
        printBoard(board);
        int a = 0;
        int c = 0;
        int d = 0;
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        // beginning of while loop
        while (player == false) {

            //player 1 turn
            System.out.println("Player 1: Which column would you like to choose?");
            a = scanner.nextInt();
            chipType = 'x';
            c = insertChip(board, a, chipType);

            //checks if player 1 won
            if (checkIfWinner(board, a, c, chipType) == true) {
                printBoard(board);
                System.out.println("Player 1 won the game!");
                break;

            }
            //checks if there is a tie after player 1 turn
            if (checkIfTie(board, a, c, chipType) == true) {
                printBoard(board);
                System.out.println("Draw. Nobody wins.");
                break;
            }


        printBoard(board);

        //player 2 turn
        System.out.println("Player 2: Which column would you like to choose?");
        a = scanner.nextInt();
        chipType = 'o';
        d = insertChip(board, a, chipType);

        //checks if player 2 won
        if (checkIfWinner(board, a, d, chipType) == true) {
            printBoard(board);
            System.out.println("Player 2 won the game!");
            break;

        }
        //checks if tie after player 2 turn
        if (checkIfTie(board, a, d, chipType) == true) {
            printBoard(board);
            System.out.println("Draw. Nobody wins.");
            break;
        }
        printBoard(board);
    }
    }

        }



