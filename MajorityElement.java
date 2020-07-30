class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int p1 = 0;
        int p2 = 1;
        while (true) {
            while (nums[p2] == nums[p1] && p2 < nums.length - 1) p2++;
            if (nums[p2] == nums[p1]) break;
            nums[p2] = -619;
            nums[p1] = -619;
            if (p2 == nums.length - 1) break;
            while (nums[p2] == -619 && p2 < nums.length - 1) p2++;
            while (nums[p1] == -619 && p1 < nums.length - 1) p1++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (nums[i] != -619) return nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[] {1, 1, 0, 0, 0, 1, 0}));
    }
}