import java.util.*;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> validSpecial = new ArrayList<>();
        for (List<Integer> offer : special) {
            int totalPrice = 0;
            for (int i = 0; i < n; i++) {
                if (offer.get(i) > needs.get(i)) {
                    totalPrice = -1;
                    break;
                }
                totalPrice += offer.get(i) * price.get(i);
            }
            if (totalPrice != -1 && totalPrice > offer.get(n)) {
                validSpecial.add(offer);
            }
        }
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, validSpecial, needs, memo);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += price.get(i) * needs.get(i);
        }

        for (List<Integer> offer : special) {
            List<Integer> updatedNeeds = new ArrayList<>(needs);
            boolean validOffer = true;
            for (int i = 0; i < needs.size(); i++) {
                if (updatedNeeds.get(i) < offer.get(i)) {
                    validOffer = false;
                    break;
                }
                updatedNeeds.set(i, updatedNeeds.get(i) - offer.get(i));
            }
            if (validOffer) {
                minCost = Math.min(minCost, offer.get(needs.size()) + dfs(price, special, updatedNeeds, memo));
            }
        }
        
        memo.put(needs, minCost);
        return minCost;
    }
}
