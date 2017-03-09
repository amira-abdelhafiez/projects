package connect4;

import java.util.Scanner;

/**
 *
 * @author Amira Mahmoud
 */
public class Connect4 {

    //COLORS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        boolean end = false;
        boolean flag = true;
        
        
        int winner = 0;
        //Game Settings
        Player[] Players = new Player[2];
        Players[0] = new Player();
        Players[1] = new Player();
        
        Board board;
        
        String userInput;
        System.out.println(ANSI_BLUE + "Please Enter Player 1's Name" + ANSI_RESET);
        userInput = scan.next();
        Players[0].setName(userInput);
        Players[0].setScore(0);
        System.out.println(ANSI_BLUE + "Please Enter Player 2's Name" + ANSI_RESET);
        userInput = scan.next();
        Players[1].setName(userInput);
        Players[1].setScore(0);
        
        while(flag){
            board = new Board();
            end = false;
            flag = showMenu();
            
            if(!flag) continue;
            int coloNum = 1;
            int turn = 1;
            int cnt = 0;
            while(!end /* Check The end of games */)
            {
                board.showBoard();
                if(turn == 1)
                    System.out.println(ANSI_RED + "Player " + Players[turn-1].getName() + "'s turn" + ANSI_RESET);
                else
                    System.out.println(ANSI_GREEN + "Player " + Players[turn-1].getName() + "'s turn" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "Please Enter coloumn Number" + ANSI_RESET);
               
                
                boolean invalid = true;
                
                while(invalid){
                    invalid = false;
                    coloNum = scan.nextInt();
                    if(coloNum < 1 || coloNum > 5){
                        invalid = true;
                        System.out.println(ANSI_YELLOW + "Invalid Coloumn Number , Please Try Again!!" + ANSI_RESET);
                    
                    }
                    else if(board.isFull(coloNum-1)){
                        invalid = true;
                        System.out.println(ANSI_YELLOW + "This coloumn is full, Choose another one" + ANSI_RESET);
                    }else{
                        break;
                    }
                    
                }
                
                int rowNum;
                rowNum = board.playerTurn(turn , coloNum-1);
                
                cnt++;
                if(cnt >= 6){
                    //check here
                    end = board.check(turn, rowNum, coloNum);
                    if(end){
                        board.showBoard();
                        winner = turn; 
                        System.out.println("");
                    }
//                    System.out.println("Colo" + coloNum + " - " + board.checkColoumns(coloNum-1, turn));
//                    System.out.println("Row" + rowNum + " - " + board.checkRows(rowNum, turn));
               
                }
                //Switch Turns
                if(turn == 1) turn = 2;
                else if(turn == 2) turn = 1;
            }
            
            if(end){
                if(winner == 0) System.out.println("Tied");
                else{
                    System.out.println(ANSI_PURPLE + "Player " + winner + " wins" + ANSI_RESET);
                    Players[winner-1].increaseScore();
                }
                System.out.print(ANSI_RED + Players[0].ToString() + ANSI_RESET);
                System.out.print(" vs ");
                System.out.print(ANSI_GREEN + Players[1].ToString() + ANSI_RESET);
                System.out.println("");
            }
        }
    }
    
    
    public static boolean showMenu()
    {
        int choice = 1;
        boolean flag = false;
        System.out.println(ANSI_BLUE + "------------------- CONNECT 4 ------------------- \n" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "NEW GAME (PRESS 1)\nEXIT    (PRESS 2)" + ANSI_RESET);
        
        boolean temp = true;
        while(temp){
            temp = false;
            System.out.print(ANSI_BLUE + "PLEASE Enter your choice : " + ANSI_RESET);
            choice = scan.nextInt();
            switch(choice){    
                case 1:
                    flag = true;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    temp = true;
                    System.out.println(ANSI_YELLOW + "Invalid input!! , Please Try Again!!" + ANSI_RESET);
                    break;
            }
        }
        return flag;
    }
}
