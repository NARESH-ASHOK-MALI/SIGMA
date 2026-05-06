public class getHappyString {
    public static void main(String[] args) {
        getHappyString solution = new getHappyString();
        int n = 3, k = 9;
        String result = solution.getHappyString(n, k);
        System.out.println(result); // Output: "cab"
    }
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n);
        Collections.sort(result);
        return k <= result.size() ? result.get(k - 1) : "";
    }
    private void backtrack(List<String> result, StringBuilder current, int n) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
                current.append(c);
                backtrack(result, current, n);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}