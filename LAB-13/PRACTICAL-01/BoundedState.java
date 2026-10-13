

public class BoundedState {
    static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (N value : values) {
            sum += value.doubleValue();
        }

        return sum / values.length;
    }

    public static void main(String[] args) {
        Integer[] ints={1,2,3,4,5,6,7,8,9,10};
        Double[] doubles={1.0,2.3,4.5,2.2};
        Long[] longs={1L,100L,23L};

        System.out.println("Integers avg:"+average(ints));
        System.out.println("Doubles avg:"+average(doubles));
        System.out.println("Longs avg:"+average(longs));

        

    }
}
