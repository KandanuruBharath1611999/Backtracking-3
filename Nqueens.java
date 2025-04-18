// Time Complexity : O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Handling '\u0000' as uninitialized cell

// Approach :
// Use backtracking to try placing one queen in each row
// For each cell in the row, check if it's safe (no queen in same column or diagonal)
// If safe, place the queen, move to the next row recursively
// After exploring, remove the queen (backtrack) to try other possibilities



import java.util.*;

public class Nqueens {
    List<List<String>> op = new ArrayList<>();
    public void helper(int i,char[][] mat,int n)
    {
        if(i>n)
        {
            List<String> sadd = new ArrayList<>();
            for(int pi = 0;pi<mat.length;pi++)
            {
                StringBuilder s = new StringBuilder();
                for(int pj=0;pj<mat[0].length;pj++)
                {
                    if(mat[pi][pj]=='\u0000')
                    {
                        s.append('.');
                    }
                    else
                    {
                        s.append(mat[pi][pj]);
                    }
                }
                sadd.add(s.toString());
            }
            op.add(sadd);
        }
        if(i<=n)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(check(mat,i,j))
                {
                    mat[i][j] = 'Q';
                    helper(i+1,mat,n);
                    mat[i][j] = '.';
                }
            }
        }
    }
    public boolean check(char[][] mat,int i,int j)
    {
        int dupi = i;
        int dupj = j;
        while(i>=0 && j>=0)
        {
            if(mat[i][j]=='Q')
            {
                return false;
            }
            i--;
            j--;
        }
        i = dupi;
        j = dupj;
        while(i>=0 && j<mat.length)
        {
            if(mat[i][j]=='Q')
            {
                return false;
            }
            i--;
            j++;
        }
        i = dupi;
        j = dupj;
        while(i>=0)
        {
            if(mat[i][j]=='Q')
            {
                return false;
            }
            i--;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) 
    {
        //n=9;
        char[][] mat = new char[n][n];
        helper(0,mat,n-1);
        return op;
    }
}