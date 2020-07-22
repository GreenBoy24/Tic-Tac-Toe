package tictactoe;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] ticTacToe = new char[3][3];
    private static int cordinateX, cordinateY;
    private static String winner;
    private static int step = 2;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = ' ';
            }
        }

        do{
            printTable();
            getCoordinates();
            getWinner();
            if(winner.equals("X wins") || winner.equals("O wins")){
                break;
            }
            if(draw()){
                winner = "Draw";
                break;
            }
        } while (true);
        printTable();
        System.out.println(winner);
    }

    private static void fillTable(){
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = cells.charAt(k);
                k++;
            }
        }
    }

    private static void getCoordinates(){
        boolean answer = true;
        do {
            System.out.println("Enter the cordinates");
            try {
                cordinateX = scanner.nextInt();
                cordinateY = scanner.nextInt();

            } catch (Exception err) {
                System.out.println("You should enter numbers!");
            }
            if (cordinateX > 3 || cordinateX < 1 || cordinateY > 3 || cordinateY < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (repeat()) {
                System.out.println("This cell is occupied! Choose another one!");
            } else if(step % 2 == 0){
                step++;
                ticTacToe[cordinateX - 1][cordinateY - 1] = 'X';
                answer = false;
                System.out.println();
            } else {
                step++;
                ticTacToe[cordinateX - 1][cordinateY - 1] = 'O';
                answer = false;
            }

        } while (answer);
    }

    private static void printTable(){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTacToe[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void getWinner(){
        boolean overlap;
        char XorY = 0;
        if(ticTacToe[0][0] == ticTacToe[1][1] && ticTacToe[0][0] == ticTacToe[2][2]){
            XorY = ticTacToe[0][0];
            overlap = true;
        } else if(ticTacToe[0][0] == ticTacToe[0][1] && ticTacToe[0][0] == ticTacToe[0][2]){
            XorY = ticTacToe[0][0];
            overlap = true;
        } else if(ticTacToe[1][0] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[1][2]){
            XorY = ticTacToe[1][0];
            overlap = true;
        } else if(ticTacToe[2][0] == ticTacToe[2][1] && ticTacToe[2][1] == ticTacToe[2][2]){
            XorY = ticTacToe[2][0];
            overlap = true;
        } else if(ticTacToe[0][0] == ticTacToe[1][0] && ticTacToe[0][0] == ticTacToe[2][0]){
            XorY = ticTacToe[0][0];
            overlap = true;
        } else if(ticTacToe[0][1] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[2][1]){
            XorY = ticTacToe[0][1];
            overlap = true;
        } else if(ticTacToe[0][2] == ticTacToe[1][2] && ticTacToe[0][2] == ticTacToe[2][2]){
            XorY = ticTacToe[0][2];
            overlap = true;
        } else if(ticTacToe[0][2] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[2][0]){
            XorY = ticTacToe[0][2];
            overlap = true;
        } else {
            overlap = false;
        }
        
        if(overlap){
            winner = XorY + " wins";
        }
    }

    private static boolean draw(){
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(ticTacToe[i][j] == 'X' || ticTacToe[i][j] == 'O'){
                    count++;
                }
            }
        }
        if(count == 9){
            return true;
        } else {
            return false;
        }
    }

    private static boolean repeat(){
        if(ticTacToe[cordinateX-1][cordinateY-1] == 'X' || ticTacToe[cordinateX-1][cordinateY-1] == 'O'){
            return true;
        }else {
            return false;
        }
    }
}
