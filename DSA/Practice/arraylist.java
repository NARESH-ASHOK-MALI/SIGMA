import java.util.ArrayList;
public class arraylist {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();

        // Add some elements to the ArrayList
        list.add("Hello"); //O(1)
        list.add("World");//O(1)
        list.add("Java");//O(1)

        //add an element at a specific index
        list.add(1, "Programming"); //O(n)

        // Print the elements of the ArrayList
        System.out.println("ArrayList: " + list);

        // Access an element by index
        System.out.println("Element at index 1: " + list.get(1));//O(1)

        // Remove an element
        list.remove("World");
        System.out.println("ArrayList after removal: " + list);//O(n)

        //Set an element at a specific index
        list.set(0, "Hi"); //O(n)
        System.out.println("ArrayList after setting index 0: " + list);

        // Check if the ArrayList contains a specific element
        System.out.println("Contains 'Java': " + list.contains("Java"));
        // Get the size of the ArrayList
        System.out.println("Size of ArrayList: " + list.size());//O(1)
    }
}
