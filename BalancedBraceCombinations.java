import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BalancedBraceCombinations {

    public List<String> generate(int n) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) { return Arrays.asList("{}"); }
        List<String> res = new LinkedList<>();
        for (int i = 0; i <= n - 1; i++) {
            List<String> comb_inside = generate(i);
            List<String> comb_outside = generate(n - 1 - i);
            for (String s : comb_inside) {
                String newS = "{" + s + "}";
                for (String s2 : comb_outside) {
                    newS += s2;
                    res.add(newS);
                } 
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BalancedBraceCombinations b = new BalancedBraceCombinations();
        List<String> res = b.generate(4);
        for (String s : res) {
            System.out.println(s);
        }
    }
}