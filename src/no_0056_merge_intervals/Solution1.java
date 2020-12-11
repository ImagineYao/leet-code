package no_0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Solution1 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        ArrayList<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            if (intervals[i][0] > last[1]) {  // 不相交
                merged.add(intervals[i]);
            } else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}
