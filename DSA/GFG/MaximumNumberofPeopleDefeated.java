// There are infinitely many people standing in a row, indexed from 1. The strength of the person at index i is i².

// Given a strength p, determine the maximum number of people that can be defeated. A person with strength x can be defeated only if p ≥ x, after which the strength p decreases by x.
public class MaximumNumberofPeopleDefeated {
    public int maxPeopleDefeated(int p) {
        int count = 0;
        int i = 1;
        
        while (true) {
            int strength = i * i; // Calculate the strength of the person at index i
            if (p >= strength) {
                p -= strength; // Decrease p by the strength of the defeated person
                count++; // Increment the count of defeated people
                i++; // Move to the next person
            } else {
                break; // If p is less than the strength, break the loop
            }
        }
        
        return count; // Return the total number of people defeated
    }

    public static void main(String[] args) {
        MaximumNumberofPeopleDefeated solution = new MaximumNumberofPeopleDefeated();
        int p = 10; // Example strength
        int result = solution.maxPeopleDefeated(p);
        System.out.println("Maximum number of people that can be defeated: " + result);
    }
}   