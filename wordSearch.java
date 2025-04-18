// Time Complexity : O(M * N * 4^L), where M x N is board size and L is word length
// Space Complexity : O(L), for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach :
// Iterate over each cell in the board to find potential starting points (matching the first character of the word)
// When a match is found, start a depth-first search (DFS) from that cell
// In DFS, mark the current cell as visited by temporarily changing its value
// Recursively explore all four directions (up, down, left, right) to match the next character in the word
// If a full match is found, set the result to true
// After exploring each path, backtrack by restoring the cell's original value to allow reuse in other paths

public class wordSearch {
    boolean op = false;
    public void helper(int[] pos,char[] ch,int i,char[][] board)
    {
        if(i==ch.length)
        {
            this.op = true;
        }
        if(i<ch.length && op==false)
        {
            int x = pos[0];
            int y= pos[1];
            char chd = board[x][y];
            board[x][y] = '.';
            if(x-1>=0 && board[x-1][y] == ch[i])
            {
                int[] send = {x-1,y}; 
                helper(send,ch,i+1,board);
            }
            if(y-1>=0 && board[x][y-1] == ch[i])
            {
                int[] send = {x,y-1}; 
                helper(send,ch,i+1,board);
            }
            if(x+1<board.length && board[x+1][y] == ch[i])
            {
                int[] send = {x+1,y}; 
                helper(send,ch,i+1,board);
            }
            if(y+1<board[0].length && board[x][y+1] == ch[i])
            {
                int[] send = {x,y+1}; 
                helper(send,ch,i+1,board);
            }
            board[x][y] = chd;
        }
    }
    public boolean exist(char[][] board, String word) 
    {
        char[] ch = word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==ch[0])
                {
                    int[] send = {i,j}; 
                    helper(send,ch,1,board);
                }
            }
        }  
        return op; 
    }
}