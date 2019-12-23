package Task1;

public class Sum {
    @MyAnnotation(a = 2, b = 5)
    public int sum(int a, int b) {
        return a + b;
    }
}
