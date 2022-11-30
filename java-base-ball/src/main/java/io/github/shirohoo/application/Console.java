package io.github.shirohoo.application;


import io.github.shirohoo.domain.Computer;
import io.github.shirohoo.domain.Numbers;
import io.github.shirohoo.domain.Score;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Computer computer = new Computer(new Numbers());
            while (true) {
                System.out.print("숫자를 입력해 주세요 : ");
                Numbers numbers = new Numbers(sc.nextLine());

                Score score = computer.compareTo(numbers);
                System.out.println(score);

                if (score.strikeOut()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int sel = sc.nextInt();

                    if (sel == 1) {
                        computer = new Computer(new Numbers());
                        sc.nextLine();
                        continue;
                    }
                    if (sel == 2) {
                        break;
                    }
                }
            }
        }
    }
}
