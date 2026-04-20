public class timeRequiredToBuy {
    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        int k = 2;
        int ans = timeRequiredToBuy(tickets, k);
        System.out.println(ans);
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        for(int i = 0; i < n; i++){
            if(i <= k){
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}
