import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {

    private String image = "\uD83D\uDC79";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("⚔️ Монстр задаёт тебе сложный пример! ⚔️");

        if (difficultGame == 1) {
            return taskMonster();
        } else {
            Random r = new Random();

            int a = r.nextInt(15 * difficultGame - 5 * difficultGame) + 5 * difficultGame;
            int b = r.nextInt(15 * difficultGame - 5 * difficultGame) + 5 * difficultGame;
            int c = r.nextInt(6 - 2) + 2;
            int d = r.nextInt(5 - 2) + 2;

            int taskType = r.nextInt(5 - 1) + 1;
            int trueAnswer;
            String taskText;

            switch (taskType) {
                case 1:
                    trueAnswer = a * a + b - c;
                    taskText = a + "² + " + b + " - " + c + " = ?";
                    break;
                case 2:
                    trueAnswer = (a + b) * c - d;
                    taskText = "(" + a + " + " + b + ") × " + c + " - " + d + " = ?";
                    break;
                case 3:
                    trueAnswer = a * b / c;
                    taskText = a + " × " + b + " ÷ " + c + " = ?";
                    break;
                case 4:
                    trueAnswer = a * a * a - b * c;
                    taskText = a + "³ - " + b + " × " + c + " = ?";
                    break;
                default:
                    trueAnswer = (a + b - c) * d + a;
                    taskText = "(" + a + " + " + b + " - " + c + ") × " + d + " + " + a + " = ?";
                    break;
            }

            System.out.println("📝 Реши пример: " + taskText);
            System.out.print("Твой ответ: ");

            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("✅ Верно! Ты победил монстра!");
                return true;
            } else {
                System.out.println("❌ Неверно! Правильный ответ: " + trueAnswer);
                System.out.println("💀 Монстр атакует...");
                return false;
            }
        }
    }

    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}