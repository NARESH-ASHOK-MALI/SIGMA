
import java.util.ArrayList;
public class pairSumII {
    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum1(list, target));
    }
    public static int[] pairSum1(ArrayList<Integer> list , int target){
        
        int bp=-1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        int[] res = new int[2];

        while (lp != rp) {
            int totalsum = list.get(lp) + list.get(rp);

            if (totalsum == target) {
                res[0] = lp + 1; // 1-based index
                res[1] = rp + 1;
                return res;
            } else if (totalsum > target) {
                rp=(rp-1+list.size())%list.size(); // Move right pointer to the left
            } else {
                lp=(lp+1)%list.size(); // Move left pointer to the right
            }
        }

        return res;
    }
}
