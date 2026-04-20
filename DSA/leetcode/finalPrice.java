public class finalPrice {
    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        int[] ans = finalPrices(prices);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = prices[i];
            for(int j = i + 1; j < n; j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}
