import java.util.*;

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);

            // Maintain min deque (increasing)
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);

            // Shrink window
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {

                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}