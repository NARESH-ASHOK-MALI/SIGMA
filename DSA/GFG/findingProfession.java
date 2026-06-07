// Consider a special family of Engineers and Doctors with following rules :

// Everybody has two children.
// First child of an Engineer is an Engineer and second child is a Doctor.
// First child of an Doctor is Doctor and second child is an Engineer.
// All generations of Doctors and Engineers start with Engineer.
// The first few levels of the family tree are shown below :
public class findingProfession {
    public static void main(String[] args) {
        int level = 4;
        int pos = 2;
        String profession = findProfession(level, pos);
        System.out.println("The profession at level " + level + " and position " + pos + " is: " + profession);
    }

    public static String findProfession(int level, int pos) {
        // Base case: The first level has only one Engineer
        int flips = Integer.bitCount(pos - 1);
        return (flips % 2 == 0) ? "Engineer" : "Doctor";
    }
}
