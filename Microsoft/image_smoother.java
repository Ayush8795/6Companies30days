class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        if(n == 1 && m == 1)
        return img;
        // System.out.println(m+", "+n);
        int[][] ans = new int[m][n];
        if(m == 1){
            ans[0][0] = (img[0][0] + img[0][1]) / 2;
            for(int i = 1; i<n-1;i++)
            {
                if(i>0)
                ans[0][i] = (img[0][i-1] + img[0][i] + img[0][i+1]) / 3;
            }
            ans[0][n-1] = (img[0][n-1] + img[0][n-2]) / 2;
            return ans;
        }
        if(n == 1){
            ans[0][0] = (img[0][0] + img[1][0]) / 2;
            for(int i = 1; i<m-1;i++)
            {
                if(i>0)
                ans[i][0] = (img[i-1][0] + img[i][0] + img[i+1][0]) / 3;
            }
            ans[m-1][0] = (img[m-1][0] + img[m-2][0]) / 2;
            return ans;
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++){
             if(i == 0 && j == 0){
                ans[i][j] = (img[i][j] + img[i][j+1] + img[i+1][j] + img[i+1][j+1]) / 4;
             }
             else if(i == 0 && j == n-1) 
             {
                ans[i][j] = (img[i][j] + img[i][j-1] + img[i+1][j] + img[i+1][j-1]) / 4;
             } 
             else if(i == m-1 && j == 0)
             {
                // System.out.println(i+", "+j);
                ans[i][j] = (img[i][j] + img[i-1][j] + img[i][j+1] + img[i-1][j+1]) / 4;
             }
             else if(i == m-1 && j == n-1){
                ans[i][j] = (img[i][j] + img[i][j-1] + img[i-1][j] + img[i-1][j-1]) / 4;
             }
             else if(i == 0 && j > 0 && j < n-1)
             {
                ans[i][j] = (img[i][j] + img[i][j-1] + img[i][j+1] + img[i+1][j-1] + img[i+1][j] + img[i+1][j+1]) / 6;
             }
             else if(i == m-1 && j > 0 && j < n-1)
             {
                ans[i][j] = (img[i][j] + img[i][j-1] + img[i][j+1] + img[i-1][j-1] + img[i-1][j] + img[i-1][j+1]) / 6;
             }
             else if(j == 0 && i > 0 && i < m-1)
             {
                ans[i][j] = (img[i][j] + img[i-1][j] + img[i+1][j] + img[i-1][j+1] + img[i][j+1] + img[i+1][j+1]) / 6;
             }
             else if(j == n-1 && i > 0 && i < m-1)
             {
                ans[i][j] = (img[i][j] + img[i-1][j] + img[i+1][j] + img[i-1][j-1] + img[i][j-1] + img[i+1][j-1]) / 6;
             }
             else{
                ans[i][j] = (img[i-1][j-1] + img[i-1][j] + img[i-1][j+1] + img[i][j-1] + img[i][j] + img[i][j+1] + img[i+1][j-1] + img[i+1][j] + img[i+1][j+1]) / 9;
             }
            }
        }
        return ans;
    }
}