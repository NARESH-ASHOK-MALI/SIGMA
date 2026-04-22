public class twoEditWords2452 {
    public static void main(String[] args) {
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        System.out.println(twoEditWords(queries, dictionary));
    }
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isTwoEditsAway(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
    public static boolean isTwoEditsAway(String s1, String s2) {
        int differences = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                if (differences > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}