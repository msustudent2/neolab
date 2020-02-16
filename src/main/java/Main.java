import java.util.*;

public class Main {
    public static void main(String[] args) throws SeparatorException {
        //int a[] = {4,5,6,7,8,9,12};
        //int a[] = {4,5,6,7,8,9};
        //int a[] = {1,1,1,1,1,1,1,2};
        //int a[] = {2,1,1};
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
