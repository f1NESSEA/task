import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testMatchesForSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("домой");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindMatchingTasksEpicInOneSubtask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("Хлеб");

        boolean expected = false;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindDifferentTasksEpicInOneSubtask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("Сыр");

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchingTasksEpicInTwoSubtasks() {
        String[] subtasks = { "Сыр свежий", "Яйца", "Хлеб свежий" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("свежий");

        boolean expected = false;
        boolean actual = epic.matches("свежий");

        Assertions.assertEquals(expected, actual);
    }
}
