class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
        /*
        Definitions:

        Let L be the distance from the start of the array to the start of the cycle.
        Let C be the length of the cycle.
        Let k be the steps slow has taken inside the cycle by the time slow and fast meet for the first time.
        Distance Travelled by Pointers:
        
        When slow and fast first meet, the slow pointer has travelled L + k steps.
        The fast pointer, moving twice as fast, has travelled 2(L + k) steps.
        Cycle Properties:
        
        The fast pointer will have travelled L + k steps plus an additional m full cycles within the cycle: 2(L + k) = L + k + mC where m is the number of complete cycles the fast pointer has travelled.
        Formulating the Meeting Point:
        
        From the above, we have: L + k = mC (the extra L steps and k steps within the cycle amount to m full cycles).
        Simplifying: L = mC - k.
        Start of the Cycle:
        
        Resetting slow to the start of the array means it now needs to travel L steps to the start of the cycle.
        Meanwhile, the fast pointer, which is k steps into the cycle, also needs to travel L steps.
        Since both L and k add up to a multiple of the cycle length C, they will meet at the start of the cycle after L steps.
        */
    }
}
