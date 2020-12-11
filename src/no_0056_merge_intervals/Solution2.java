package no_0056_merge_intervals;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Solution2 {

    public int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);

        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[cnt][1]) {  // 相交
                intervals[cnt][1] = Math.max(intervals[cnt][1], intervals[i][1]);
            } else {
                cnt++;
                intervals[cnt] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, cnt + 1);
    }

    private void quickSort(int[][] arr, int start, int end) {
        if (start < end) {
            int i = start, j = end;
            int[] item = arr[i];

            while (i < j) {
                while (i < j) {  // 从右往左找出第一个小于item的元素
                    if (arr[j][0] < item[0] || (arr[j][0] == item[0] && arr[j][1] < item[1]))
                        break;
                    j--;
                }
                if (i < j)
                    arr[i++] = arr[j];

                while (i < j) {  // 从左往右找出第一个大于item的元素
                    if (arr[i][0] > item[0] || (arr[i][0] == item[0] && arr[i][1] > item[1]))
                        break;
                    i++;
                }
                if (i < j)
                    arr[j--] = arr[i];
            }

            arr[i] = item;

            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

}