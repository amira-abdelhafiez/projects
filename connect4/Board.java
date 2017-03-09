package connect4;

/**
 *
 * @author Amira Mahmoud
 */
public class Board {
    
    //Height and Width
    final static int WIDTH = 5;
    final static int HEIGHT = 5;
    
    //Boards
    public static char board[][] = new char[WIDTH][HEIGHT];
    public static int proxyBoard[][] = new int[WIDTH][HEIGHT];
    
    
    //Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    
    Board(){
        NEWGAME();
    }
    
    public void showBoard()
    {
        System.out.println("  1   2   3   4   5");
        System.out.println(" --  --  --  --  --");
        for(int i = 0 ; i < WIDTH ; i++){
            System.out.print("| ");
            for(int j = 0 ; j < HEIGHT ; j++){
                if(j == 0){ 
                    if(proxyBoard[i][j] == 1){
                        System.out.print(ANSI_RED + "O" + ANSI_RESET);
                    }else if(proxyBoard[i][j] == 2){
                        System.out.print(ANSI_GREEN + "O" + ANSI_RESET);
                    }else{
                        System.out.print(" ");
                    }
                    
                }
                else{
                    if(proxyBoard[i][j] == 1){
                        System.out.print(ANSI_RED + "O" + ANSI_RESET);
                    }else if(proxyBoard[i][j] == 2){
                        System.out.print(ANSI_GREEN + "O" + ANSI_RESET);
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println(" --  --  --  --  --");
        }
        System.out.println("");
    }
    
    public void NEWGAME()
    {
        for(int i = 0 ; i < WIDTH ; i++){
            for(int j = 0 ; j < HEIGHT ; j++){
                board[i][j]=' ';
                
            }
        }
        
        for(int i = 0 ; i < WIDTH ; i++){
            for(int j = 0 ; j < HEIGHT ; j++){
                proxyBoard[i][j] = 0;
                
            }
        }
        
    }
    
    public int playerTurn(int playerNum , int colNum)
    {
        int row = 0;
        for(int i = HEIGHT-1 ; i >= 0 ; i--){
            if(proxyBoard[i][colNum] == 0){
                proxyBoard[i][colNum] = playerNum;
                row = i;
                break;
            }
        }
       return row;
    }
    
    public boolean isFull(int coloNum)
    {
       
        if(proxyBoard[0][coloNum] == 0){
            return false;
        }
        else 
            return true;
    }
    
    public boolean check(int playerNum  , int rowNum , int coloNum){
        coloNum--;
        boolean row = false ,coloumn = false, diagonal = false;
        row = checkRows(rowNum , playerNum);
        coloumn = checkColoumns(coloNum , playerNum);
        diagonal = checkDiagonal(rowNum , coloNum , playerNum);
        if(row || coloumn || diagonal) return true;
        else return false;
    }
    
    public boolean checkRows(int rowNum , int playerNum){
        boolean flag = false;
        for(int i = 0 ; i < 2 ; i++){
            if((proxyBoard[rowNum][i] == proxyBoard[rowNum][i+1]) && (proxyBoard[rowNum][i+1] == proxyBoard[rowNum][i+2])
                    && (proxyBoard[rowNum][i+2] == proxyBoard[rowNum][i+3]) && (proxyBoard[rowNum][i+3] == playerNum) ){
                flag = true;
            }
        }
        return flag;
    }
    public boolean checkColoumns(int coloNum , int playerNum){
        boolean flag = false;
        for(int i = 0 ; i < 2 ; i++){
            if((proxyBoard[i][coloNum] == proxyBoard[i+1][coloNum]) && (proxyBoard[i+1][coloNum] == proxyBoard[i+2][coloNum])
                    && (proxyBoard[i+2][coloNum] == proxyBoard[i+3][coloNum]) && (proxyBoard[i+3][coloNum] == playerNum) ){
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean checkDiagonal(int rowNum , int coloNum , int playerNum)
    {
        boolean flag = false;
        
        //Diagonal 1 00
        
        if(Math.abs(0 - rowNum) == Math.abs(0 - coloNum)){
            for(int i = 0 ; i < 2 ; i++){
                    if((proxyBoard[i][i] == proxyBoard[i+1][i+1]) && (proxyBoard[i+1][i+1] == proxyBoard[i+2][i+2])
                    && (proxyBoard[i+2][i+2] == proxyBoard[i+3][i+3]) && (proxyBoard[i+3][i+3] == playerNum) ){
                        flag = true;
                    }
            }
        }
        
        //Diagonal 2 04
        if(Math.abs(0 - rowNum) == Math.abs(4 - coloNum)){
            for(int i = 0 ; i < 2 ; i++){
                    if((proxyBoard[i][4-i] == proxyBoard[i+1][3-i]) && (proxyBoard[i+1][3-i] == proxyBoard[i+2][2-i])
                    && (proxyBoard[i+2][2-i] == proxyBoard[i+3][1-i]) && (proxyBoard[i+3][1-i] == playerNum) ){
                        flag = true;
                    }
            }
        }
        //Diagonal 3 01
        
        if(Math.abs(0 - rowNum) == Math.abs(1 - coloNum)){
            if((proxyBoard[0][1] == proxyBoard[1][2]) && (proxyBoard[1][2] == proxyBoard[2][3]) &&
                    (proxyBoard[2][3] == proxyBoard[3][4]) && (proxyBoard[3][4] == playerNum)){
                flag = true;
            }
        }
        
        //Diagonal 4 10
        
        if(Math.abs(1 - rowNum) == Math.abs(0 - coloNum)){
            if((proxyBoard[1][0] == proxyBoard[2][1]) && (proxyBoard[2][1] == proxyBoard[3][2]) &&
                    (proxyBoard[3][2] == proxyBoard[4][3]) && (proxyBoard[4][3] == playerNum)){
                flag = true;
            }
        }
        
        // Diagonal 5 03
        
        if(Math.abs(0 - rowNum) == Math.abs(3 - coloNum)){
            if((proxyBoard[0][3] == proxyBoard[1][2]) && (proxyBoard[1][2] == proxyBoard[2][1]) &&
                    (proxyBoard[2][1] == proxyBoard[3][0]) && (proxyBoard[3][0] == playerNum)){
                flag = true;
            }
        }
        
        // Diagonal 6 14
        
        if(Math.abs(1 - rowNum) == Math.abs(4 - coloNum)){
            if((proxyBoard[1][4] == proxyBoard[2][3]) && (proxyBoard[2][3] == proxyBoard[3][2]) &&
                    (proxyBoard[3][2] == proxyBoard[4][1]) && (proxyBoard[4][1] == playerNum)){
                flag = true;
            }
        }
        return flag;
        
    }
    
    /*
    
       0   1   2   3   4
    0  00  01  02  03  04
    
    1  10  11  12  13  14
    
    2  20  21  22  23  24
    
    3  30  31  32  33  34
    
    4  40  41  42  43  44
    
    */
    
}



/*
boolean flag = false;
        
        // Cells with No Diagonal 
        
        if((Math.abs(rowNum-coloNum) == 2 ) && (rowNum == 2 || coloNum == 2)){
            return false;
        }
        
        
        // Cells with One Diagonal
        
        else if(rowNum != 2 && coloNum != 2){
            if(rowNum == coloNum){
                for(int i = 0 ; i < 2 ; i++){
                    if((proxyBoard[i][i] == proxyBoard[i+1][i+1]) && (proxyBoard[i+1][i+1] == proxyBoard[i+2][i+2])
                    && (proxyBoard[i+2][i+2] == proxyBoard[i+3][i+3]) && (proxyBoard[i+3][i+3] == playerNum) ){
                        flag = true;
                    }
                }
            }else if(Math.abs(rowNum - coloNum) == 2){
                for(int i = 0 ; i < 2 ; i++){
                    if((proxyBoard[i][4-i] == proxyBoard[i+1][3-i]) && (proxyBoard[i+1][3-i] == proxyBoard[i+2][2-i])
                    && (proxyBoard[i+2][2-i] == proxyBoard[i+3][1-i]) && (proxyBoard[i+3][1-i] == playerNum) ){
                        flag = true;
                    }
                }
            }
        }
        
        // Cells with Two Diagonal
        else{
            
        }
        return flag;
*/
