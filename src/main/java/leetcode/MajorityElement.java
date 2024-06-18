package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(usingHashMap(new int[]{1, 1, 2, 1, 1,}));

    }

    public static int sortingFirst(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static int usingHashMap(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        n/=2;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }
        return 0;
    }


}
