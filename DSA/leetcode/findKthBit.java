// Given two positive integers n and k, the binary string Sn is formed as follows:

// S1 = "0"
// Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
// Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
public class findKthBit {
    public static void main(String[] args) {
        findKthBit solution = new findKthBit();
        int n = 3, k = 1;
        char result = solution.findKthBit(n, k);
        System.out.println(result); // Output: '0'
    }

    public char findKthBit(int n, int k) {
        String s = generateString(n);
        return s.charAt(k - 1);
    }

    private String generateString(int n) {
        if (n == 1) {
            return "0";
        }
        String prev = generateString(n - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        sb.append("1");
        sb.append(invertAndReverse(prev));
        return sb.toString();
    }

    private String invertAndReverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
