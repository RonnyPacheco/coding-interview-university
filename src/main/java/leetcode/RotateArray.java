package leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }

    public static void rotate(int[] nums, int k){
        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[(i+k) % (nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[i];
        }
    }
}
