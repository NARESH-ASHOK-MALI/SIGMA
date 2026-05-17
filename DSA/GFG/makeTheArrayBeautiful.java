// Given an array of negative and non-negative integers. You need to make the array beautiful.

// An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or positive. You can do the following operation any number of times until the array becomes beautiful.
// If two adjacent are different i.e. one of them is negative and other is positive, remove them. 
// Return the beautiful array after performing the above operation.
// An empty array is also a beautiful array.
// There can be multiple beautiful output arrays. For consistencty with the test cases, scan the array from left to right for removing two adjacent.

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class makeTheArrayBeautiful {
    public List<Integer> makeBeautiful(int[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (!stack.isEmpty() && ((stack.peek() < 0 && num >= 0) || (stack.peek() >= 0 && num < 0))) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);

        return result;
    }
}
