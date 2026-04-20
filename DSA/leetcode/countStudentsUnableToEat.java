public class countStudentsUnableToEat {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        int ans = countStudents(students, sandwiches);
        System.out.println(ans);
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int count0 = 0; // Count of students preferring sandwich type 0
        int count1 = 0; // Count of students preferring sandwich type 1

        // Count the number of students preferring each sandwich type
        for (int student : students) {
            if (student == 0) {
                count0++;
            } else {
                count1++;
            }
        }

        // Iterate through the sandwiches and serve them to the students
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (count0 > 0) {
                    count0--; // Serve a type 0 sandwich
                } else {
                    break; // No more students prefer type 0, stop serving
                }
            } else {
                if (count1 > 0) {
                    count1--; // Serve a type 1 sandwich
                } else {
                    break; // No more students prefer type 1, stop serving
                }
            }
        }

        // The remaining students who couldn't eat are those who still prefer their respective sandwich types
        return count0 + count1;
    }
}
