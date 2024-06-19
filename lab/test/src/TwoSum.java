/**
 * Created by Chelsea on 2024-05-30
 */

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int left = nums[i];
      for (int t = 0; t < nums.length - 1; t++) {
        int right = nums[t];
        if (target - left == right) {
          result = new int[] {i, t};
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2,7,11,15};
    int[] result = twoSum(nums, 9);
    for(int i : result) {
      System.out.println(i);
    }
  }
}
