import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        if (n != target.length()) return -1;

        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == Long.MAX_VALUE) continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] == Long.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], 
                                        dist[i][k] + dist[k][j]);
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            
            if (from == to) continue;
            
            if (dist[from][to] == Long.MAX_VALUE) {
                return -1; 
            }
            
            totalCost += dist[from][to];
        }
        
        return totalCost;
    }
}