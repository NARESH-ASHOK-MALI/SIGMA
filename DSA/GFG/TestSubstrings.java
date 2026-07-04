public class TestSubstrings {
    public static void main(String[] args) {
        Substringswithmore1sthan0s solver = new Substringswithmore1sthan0s();
        System.out.println(solver.countSubstrings("011")); // expect 4
        System.out.println(solver.countSubstrings("0000")); // expect 0
        System.out.println(solver.countSubstrings("1")); // expect 1
        System.out.println(solver.countSubstrings("01")); // expect 1
        System.out.println(solver.countSubstrings("1101")); // quick sanity check
    }
}