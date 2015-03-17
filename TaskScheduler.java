/* Given the interface below, implement a task scheduler.
 *
 *
 * interface Task {
 *     void Run();
 *     Set<Task> GetDependencies();
 * }
 * Additionally, the task scheduler should follow two rules. 
 *
 * 1. Each task may only be executed once. 
 * 2. The dependencies of a task should be executed before the task itself.
 *
 */

public class TaskScheduler {
    
    Set<Task> tasks = new HashSet<>();
    Set<Task> visitedTasks = new HashSet<>();
    
    public void TaskScehduler(Set<Task> tasks) {
        this.tasks = tasks;
    }
    
    public void ExecuteTasks(Set<Task> tasks) {
        for( Task task : tasks) {
            if (!visitedTasks.contains(task)) {
                Set<Task> subtasks = task.GetDependencies();
                if (subtasks.size() > 0)
                    ExecuteTasks(subtasks);
                task.Run();
                visitedTasks.add(task);
            } 
        }
    }
}
