// You are given an array tasks where tasks[i] = [actuali, minimumi]:

// actuali is the actual amount of energy you spend to finish the ith task.
// minimumi is the minimum amount of energy you require to begin the ith task.
// For example, if the task is [10, 12] and your current energy is 11, you cannot start this task. However, if your current energy is 13, you can complete this task, and your energy will be 3 after finishing it.

// You can finish the tasks in any order you like.

// Return the minimum initial amount of energy you will need to finish all the tasks.
public class MinimumInitialEnergytoFinishTasks1665 {
    public static void main(String [] args){
        int[][] tasks = {{1,2},{2,4},{4,8}};
        System.out.println(minimumEffort(tasks));
    }
    public static int minimumEffort(int[][] tasks) {
        // Sort tasks based on the difference between minimum and actual energy required
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int totalEnergy = 0; // Total energy spent on tasks
        int initialEnergy = 0; // Initial energy required
        
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            // If current total energy is less than the minimum required for the task
            if (totalEnergy < minimum) {
                initialEnergy += (minimum - totalEnergy); // Increase initial energy to meet the requirement
                totalEnergy = minimum; // Update total energy to the new initial energy
            }
            
            totalEnergy -= actual; // Spend energy on the task
        }
        
        return initialEnergy; // Return the minimum initial energy required
    }
}
