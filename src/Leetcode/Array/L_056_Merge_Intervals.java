package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *  Given a collection of intervals, merge all overlapping intervals.
 *  For example,
 *  Given [1,3],[2,6],[8,10],[15,18],
 *  return [1,6],[8,10],[15,18].
 *
 *  思路：1. 先根据start排序
 *       2. 一遍扫描做merge: overlap or disjoint
 */
public class L_056_Merge_Intervals {
 public static class Interval {
   int start;
   int end;
   Interval() { start = 0; end = 0; }
   Interval(int s, int e) { start = s; end = e; }
  }

  /**
   * 时间：排序：O(nlog(n)), merge: O(n)
   */
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
      return intervals;
    }

    List<Interval> result = new ArrayList<>();
    Collections.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });
    // For java 1.8+:
    // intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

    int prevStart = intervals.get(0).start;
    int prevEnd = intervals.get(0).end;

    for (Interval interval : intervals) {
      if (interval.start <= prevEnd) { // Overlap
        prevEnd = Math.max(interval.end, prevEnd);
      } else { // Disjoint
        result.add(new Interval(prevStart, prevEnd));
        prevStart = interval.start;
        prevEnd = interval.end;
      }
    }
    // Add the last interval
    result.add(new Interval(prevStart, prevEnd));
    return result;
  }

  public static void main(String[] args) {
    L_056_Merge_Intervals solution = new L_056_Merge_Intervals();
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(1,3));
    list.add(new Interval(2,6));
    list.add(new Interval(8,10));
    list.add(new Interval(15,18));
    List<Interval> result = solution.merge(list);
    for (Interval item : result) {
      System.out.println(item.start + ", " + item.end);
    }
  }
}
