import java.util.*;

public class labuladong {
    public static void main(String[] args) {
        Integer[] nums = { 3, 1, 4, 1, 5, 9 };
        Arrays.sort(nums, (a, b) -> b - a);
        System.out.println(Arrays.toString(nums));
        Integer[] nums2 = { 3, 1, 4, 1, 5, 9 };
        Arrays.sort(nums2, (a, b) -> Integer.compare(a, b));
        System.out.println(Arrays.toString(nums2));
    }
}
