import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void ShouldFindSimpleTaskMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        // boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);

    }

    @Test
    public void ShouldFindSimpleTaskMatchesFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);

    }

    @Test
    public void ShouldFindEpicMatchesTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");
        Assertions.assertTrue(actual);

    }

    @Test
    public void ShouldFindEpicMatchesFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Лимон");
        Assertions.assertFalse(actual);

    }

    @Test
    public void ShouldFindMeetingMatchesTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);

    }

    @Test
    public void ShouldFindMeetingMatchesFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Тренировка");
        Assertions.assertFalse(actual);

    }
}