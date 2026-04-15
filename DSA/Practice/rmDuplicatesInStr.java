public class rmDuplicatesInStr {
    public static void main(String[] args) {
        String str = "aabbccddeeff"; // Change this value to test with different strings
        boolean[] map = new boolean[26]; // Assuming only lowercase letters
        removeDuplicates(str, 0, new StringBuilder(), map);
    }
    public static void removeDuplicates(String str,int idx, StringBuilder newStr,boolean[] map){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']){
            removeDuplicates(str,idx+1,newStr,map);
        }else{
            map[currChar-'a']=true;
            removeDuplicates(str,idx+1,newStr.append(currChar),map);
        }

    }
}
