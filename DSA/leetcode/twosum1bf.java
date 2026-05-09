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
    public static boolean pairSum(ArrayList<Integer> list , int target){
        int lp=0;
        int rp=list.size()-1;
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
