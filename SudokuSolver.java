public class SudokuSolver {
    public static boolean isSafe(char [][] board,int row,int col,int number){

        // row and column
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(char)(number+'0')){
                return false;
            }
            if(board[row][i]==(char)(number+'0')){
                return false;
            }
        }

        //for grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(number+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper(char [][] board,int row,int col){
        if(row==board.length){
            return true;
        }
        int nrow=0;
        int ncol=0;
        //increased column by 1
        if(col !=board.length-1){
            nrow=row;
            ncol=col+1;
        }
        //increased row by 1 
        else{
            nrow=row+1;
            ncol=0;
        }


        if(board[row][col] !='.'){  // if a numer is already placed then mover to next row or column
            return helper(board,nrow,ncol);
            
        }
        else{   // place the number from 1 to 9 on empty space 
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){   // checks the number is valid for alloting
                    board[row][col]=(char)(i+'0');
                
                    if(helper(board,nrow,ncol)){
                      return true;
                    }
                
                    board[row][col]='.';
                }
            }
        }
        return false;//when all the eempt spaces would be filled
    }

    public static void printBoard(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"");
            }
            System.out.println();
        }
    } 

    





    public static void main(String[] args) {
        char [][]board={ 
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}        
        };
        if(helper(board,0,0)){
            printBoard(board);
        }
    }
}