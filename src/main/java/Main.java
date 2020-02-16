import java.util.*;

/*
    Добрый день! Класс Main существует просто так :) набор в тестов найдете в SeparatorTest,
    реализацию задачи в классе Separator.
 */


public class Main {
    public static void main(String[] args) throws SeparatorException {
        int a[] = {1,1,1,1,1,1,1,1,1,1,9,9,2};
        List<List<Integer>> result = Separator.separate(a, 3);
        if(result.size() != 0) {
            System.out.println(result);
        }
        else {
            System.out.println("I can't do it!");
        }
    }
}
