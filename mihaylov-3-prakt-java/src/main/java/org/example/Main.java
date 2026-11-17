package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        zadachi();
//        anagram();
//        popular_word();
        spisok10chisel();
    }

    public static void zadachi() {
        List<String> spisok_zadach = new ArrayList<>();


        while (true) {

            System.out.println("1 - добавить задачу");
            System.out.println("2 - удалить первую задачу");
            System.out.println("3 - удалить задачу по номеру");
            System.out.println("4 - показатаь все задачи");
            System.out.println("5 - выход");
            System.out.println(" ");
            System.out.println("Введите нужный пункт: ");

            Scanner uc = new Scanner(System.in);


            int user_choice = uc.nextInt();

            if (user_choice == 1) {
                System.out.println("Введите текст задачи");
                Scanner uz = new Scanner(System.in);
                String user_zadacha = uz.nextLine();
                spisok_zadach.add(user_zadacha);
                System.out.print("Задача ");
                System.out.print(spisok_zadach);
                System.out.println(" добавлена в конец списка");
                System.out.println(" ");


            } else if (user_choice == 2) {
                if (spisok_zadach.size() == 0) {
                    System.out.println("Список пуст");
                    System.out.println(" ");

                } else {
                    spisok_zadach.removeFirst();
                    System.out.println("Первая задача была удалена");
                    System.out.println(spisok_zadach);
                    System.out.println(" ");
                }

            } else if (user_choice == 3) {
                System.out.println("Введите номер задачи которую хотите удалить: ");
                Scanner un = new Scanner(System.in);
                int user_number = un.nextInt();
                if (user_number < spisok_zadach.size() || user_number > spisok_zadach.size()) {
                    System.out.println("Введеный номер вне диапазона");
                    System.out.println(" ");

                } else {
                    spisok_zadach.remove(user_number - 1);
                    System.out.println("Задача номер" + user_number + "Удалена");
                    System.out.println(spisok_zadach);
                    System.out.println(" ");
                }

            } else if (user_choice == 4) {
                System.out.println(spisok_zadach);


            } else if (user_choice == 5) {
                System.out.println("Вы вышли");
                System.out.println("Досвидания");
                break;


            } else {
                System.out.println("Неправильный ввод");
                System.out.println(" ");
            }

        }
    }

    public static void anagram() {
        List<String> input = List.of(
                "listen", "silent", "enlist",
                "hello", "world",
                "cat", "act", "tac"
        );

        Map<String, List<String>> groups = new HashMap<>();

        for (String word : input) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);

        }
        List<List<String>> result = new ArrayList<>(groups.values());

        System.out.println(result);
    }


    public static void popular_word() {
        String text = "java is great java is is java great powerful powerful java too great";
        int N = 3;

        String[] words = text.toLowerCase().split(" ");

        Map<String, Integer> popular = new HashMap<>();

        for (String word : words) {
            if (popular.containsKey(word)) {
                popular.put(word, popular.get(word) + 1);
            } else {
                popular.put(word, 1);
            }
        }

        List<String> result = new ArrayList<>(popular.keySet());

        for (int i = 0; i < result.size(); i++) {
            for (int b = i + 1; b < result.size(); b++) {
                if (popular.get(result.get(b)) > popular.get(result.get(i))) {

                    String temp = result.get(i);
                    result.set(i, result.get(b));
                    result.set(b, temp);
                }
            }
        }
        System.out.println(result.subList(0, N));
    }
    public static void spisok10chisel() {
        List<Integer>nums = new ArrayList<>(List.of(4,2,7,2,9,4,1,7,3,9));

        while (true){
            System.out.println("1 - Вывести исходный список");
            System.out.println("2 - Создать новый список уникальных элементов");
            System.out.println("3 - Вывести новый список");
            System.out.println("4 - Вывести сколько раз встречаются уникальные числа");
            System.out.println("5 - Максимальный и минимальный элемент нового списка");
            System.out.println("6 - Найти сумму всех элементов и ср арифмитическое");
            System.out.println(" ");
            System.out.println("Введите нужный пункт: ");


            List<Integer> numsNonRepeat = new ArrayList<>();
            Map<Integer, Integer> counter = new HashMap<>();

            for (int i: nums){
                if(numsNonRepeat.contains(i)){
                    counter.put(i, counter.get(i)+1);
                } else {
                    numsNonRepeat.add(i);
                    counter.put(i, 1);
                }
            }


            Scanner uc = new Scanner(System.in);

            int user_choice = uc.nextInt();

            if (user_choice == 1) {
                System.out.println(nums);
                System.out.println(" ");

            } else if (user_choice == 4){


                System.out.println(numsNonRepeat);
                for (int i:numsNonRepeat){
                    System.out.print(i + " - " + counter.get(i) + " раза, ");
                }
                System.out.println(" ");

            } else if (user_choice == 2){

                Scanner un = new Scanner(System.in);

                System.out.println("Введите целые числа через пробел: ");
                String input = un.nextLine();

                int[] unique = new int[0];

                String[] numbers = input.split("\\s+");

                for (String text : numbers) {
                    int number = Integer.parseInt(text);
                    boolean exists = false;

                    for (int value : unique) {
                        if (value == number) {
                            exists == true;
                            break;
                        }
                    }

                }

            } else if (user_choice == 5) {


                int max = numsNonRepeat.get(0);
                int min = numsNonRepeat.get(0);

                for (int i = 0; i < numsNonRepeat.size()-1; i++){
                    if (max < numsNonRepeat.get(i)){
                        max = numsNonRepeat.get(i);
                    } else if (min > numsNonRepeat.get(i)) {
                        min = numsNonRepeat.get(i);
                    }
                }
                System.out.println("Минимальное: " + min + ", Маскимальное: " + max);

            } else if (user_choice == 6){

                float sum = 0;

                for (int i: numsNonRepeat){
                    sum += i;
                }
                float avg = sum / numsNonRepeat.size();
                System.out.println("Сумма: " + sum + ", Среднее арифмитическое: " + avg);
            }

        }


    }

}
