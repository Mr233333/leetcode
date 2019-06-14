public class StripArray {

    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int startIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                current = nums[i];
            } else {
                if (current != nums[i]) {
                    nums[startIndex++] = nums[i];
                    current = nums[i];
                }
            }
        }
        return startIndex + 1;
    }

    public static void main(String[] args) {
        StripArray stripArray = new StripArray();
        int[] testCase = {1, 1, 2};
        stripArray.removeDuplicates(testCase);
    }
}
