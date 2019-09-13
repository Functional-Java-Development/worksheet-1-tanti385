import java.util.Arrays;
        import java.util.Comparator;
import java.util.List;

public class Main {

    private static Integer[] arrayInt = new Integer[100];

    public static void main(String[] args) {

        Arrays.setAll(arrayInt, Main::getRandom);

        Comparator<Integer> cmp = (o1,o2) -> {
            if (Integer.compare(o1.toString().length(), o2.toString().length())==0){
                return Integer.compare(o2,o1);
            }
            return (Integer.compare(o1.toString().length(), o2.toString().length()));
        };

        Arrays.sort(arrayInt, cmp);
        System.out.println(Arrays.toString(arrayInt));

        var xyzList = new FilteredList<Integer>(element -> (element%2 == 1));
        xyzList.add(1);
        xyzList.add(5);
        xyzList.forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

        xyzList.addAll(List.of(3,5,7));
        xyzList.forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

        xyzList.addAll(3,List.of(31,15,17,1));
        xyzList.forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

        var abcList = new AdvancedFilteredList<Integer>((list, e) -> {
            for (Integer element : list) {
                if (element == e) {
                    throw new IllegalArgumentException("Number already exists!!");
                }
            }

            return e;
        });

        abcList.add(1);
        abcList.add(1);
    }


    public static int getRandom(final int index) {

        return (int) (Math.random() * 100.00);
    }


}
