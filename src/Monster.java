import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDDF\u200D";
    private final int x, y;
    Random r = new Random();

    Monster(int sizeBoard){
        this.y = r.nextInt(sizeBoard - 1);
        this.x = r.nextInt(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int perX, int perY){
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean taskMonster(int difficultGame){
        System.out.println("⚔️ Реши задачу, чтобы победить монстра! ⚔️");

        int trueAnswer;
        String taskText;

        int taskType = r.nextInt(4) + 1;

        switch (taskType) {
            case 1:
                int a = r.nextInt(20) + 1;
                int b = r.nextInt(10) + 1;
                int c = r.nextInt(5) + 1;
                trueAnswer = a + b * c;
                taskText = a + " + " + b + " × " + c + " = ?";
                break;

            case 2:
                int d = r.nextInt(30) + 5;
                int e = r.nextInt(20) + 1;
                int f = r.nextInt(15) + 1;
                trueAnswer = d + e + f;
                taskText = d + " + " + e + " + " + f + " = ?";
                break;

            case 3:
                int g = r.nextInt(15) + 5;
                int h = r.nextInt(10) + 3;
                int missing = r.nextInt(h) + 1;
                trueAnswer = missing;
                taskText = g + " + ? = " + (g + missing) + "  (Найди ?)";
                break;

            default:
                int i = r.nextInt(50) + 10;
                int j = r.nextInt(50) + 10;
                trueAnswer = Math.max(i, j);
                taskText = "Какое число больше: " + i + " или " + j + "? (введи большее)";
                break;
        }

        System.out.println("📝 " + taskText);
        System.out.print("Твой ответ: ");

        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (trueAnswer == ans) {
            System.out.println("✅ Верно! Ты победил монстра!");
            return true;
        } else {
            System.out.println("❌ Неверно! Правильный ответ: " + trueAnswer);
            System.out.println("💀 Ты проиграл эту битву!");
            return false;
        }
    }
}