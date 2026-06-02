class Solution {
    public int maxProfit(int[] price) {
        int minprice=price[0];
        int profit=0;
        for(int i=0;i<price.length;i++){
            minprice=Math.min(minprice,price[i]);
            profit=Math.max(profit,price[i]-minprice);
        }
        return profit;
    }
}