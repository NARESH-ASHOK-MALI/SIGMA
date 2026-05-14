import java.util.ArrayList;
public class twosum1bf {
    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(11);
        list.add(3);
        int target = 9;
        System.out.println(pairSum(list, target));
    }
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;
        int[] res = new int[2];

        while (lp < rp) {
            int totalsum = numbers[lp] + numbers[rp];

            if (totalsum == target) {
                res[0] = lp + 1; // 1-based index
                res[1] = rp + 1;
                return res;
            } else if (totalsum > target) {
                rp--;
            } else {
                lp++;
            }
        }

        return res; 
    }
    public static boolean pairSum1(ArrayList<Integer> list , int target){
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }
}
