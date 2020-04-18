package com.kndykndy.epi.primitivetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BootCamp {

    private void ch4() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.SIZE);
        System.out.println(Boolean.TRUE);

        System.out.println(Double.valueOf("2.58")); // returns Double
        System.out.println(Double.parseDouble("2.58")); // returns double

        System.out.println(Float.toString(-1.58f));
        System.out.println(Float.NaN);
        System.out.println(Float.NaN == Float.NaN); // always

        System.out.println(Math.abs(-1.58));
        System.out.println(Math.ceil(2.15));
        System.out.println(Math.floor(3.15));

        final Object[] a = new Integer[]{1, 2, 3};
        System.out.println(Stream.of(a).map(Object::toString).collect(Collectors.joining(",")));

//        final Integer[] b = new int[]{0,1,2}; // won't compile

        Random x = new Random();
        System.out.println(
            x.nextInt(16)); // value between 0 (inclusive) and the specified value (exclusive)
        System.out.println(x.nextInt()); // 2^32
        System.out.println(x.nextBoolean()); // uniform normal pseudorandom boolean value
        System.out.println(x.nextDouble()); // between 0.0 and 1.0
    }

    private void ch5() {
        final List<Integer> a = new ArrayList<Integer>() {{
            add(1);
        }};
        final List<Integer> b = new ArrayList<>(List.of(2, 3, 4)); // @since 9
        final List<Integer> c = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println(Stream.of(a).map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(Stream.of(b).map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(Stream.of(c).map(Object::toString).collect(Collectors.joining(",")));

        Collections.swap(c, 0, 2);
        System.out.println(Stream.of(c).map(Object::toString).collect(Collectors.joining(",")));

        final int[] d = new int[]{123, 24, 3786}; // initialisation
        final int e[] = new int[]{1, 2, 3}; // also initialisation
        final int[] l = {1, 17, 10, -1, -5}; // one more
        final int[] f = new int[3]; // initialisation, all 0

        System.out.println(Arrays.binarySearch(d, 5)); // -1 as not found
        System.out.println(Arrays.binarySearch(d, 3786)); // found at index 2

        int[] g = Arrays.copyOf(d, 5);
        System.out.println(
            Arrays.stream(g).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        int[] h = Arrays.copyOfRange(d, 1, 2); // incl, excl
        System.out.println(
            Arrays.stream(h).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        int[] i = new int[5];
        Arrays.fill(i, 17);
        System.out.println(
            Arrays.stream(i).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        int[] j = new int[]{1, 17, 10, -1, -5};
        Arrays.sort(j);
        System.out.println(
            Arrays.stream(j).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Integer[] k = new Integer[]{1, 17, 10, -1, -5};
        Arrays.sort(k, Comparator.reverseOrder());
        System.out.println(Arrays.toString(k));

//        Arrays.sort(l, Collections.reverseOrder()); // cannot be done int[] and T[]

        int[] p = new int[4];
        System.arraycopy(l, 1, p, 0, 4);
        System.out.println(Arrays.toString(l) + " -> " + Arrays.toString(p));
    }

    private void ch6() {
        String a1 = "abcdef";
        System.out.println(Arrays.toString(a1.toCharArray()));

        char[] c1 = {'a', 'b', 'c'};
        System.out.println(new String(c1));

        System.out.println("abc".compareTo("cba")); // -2, lexicographically less
        System.out.println("foo".concat("bar"));
        System.out.println("foobar".substring(1));
        System.out.println(Arrays.toString("foo::bar::abc".split("::")));

        System.out.println("ab".chars().reduce(0, (currentSum, c) -> currentSum * 10 + c - '0'));
    }

    private void ch7() {
        // !!!
        // Arrays.asList returns ArrayList, THAT IS NOT a java.util.ArrayList

        List<Integer> a1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(a1.indexOf(5));
        a1.add(1, 7);
        System.out.println(a1.stream().map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(
            a1.subList(2, 5).stream().map(Object::toString).collect(Collectors.joining(",")));
        a1.retainAll(List.of(1, 7, 246));
        System.out.println(a1.stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    private void chMaps() {
        System.out.println("HashMap:");
        final Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1, null);
        m1.put(2, 1337);
        m1.computeIfAbsent(1, k -> 666);
        m1.computeIfAbsent(2, k -> 666);
        m1.forEach((key, value) -> System.out.println(key + "-" + value));

        System.out.println("HashMap 2:");
        final Map<Integer, Integer> m12 = new HashMap<>();
        IntStream.of(1, 3, 5, 4, 2).forEach(v -> m12.put(v, v * 2));
        m12.forEach((key, value) -> System.out.println(key + "-" + value));

        System.out.println("TreeMap:");
        final Map<Integer, Integer> m2 = new TreeMap<>();
        IntStream.range(1, 5).forEach(v -> m2.put(v, v * 2));
        m2.forEach((key, value) -> System.out.println(key + "-" + value));

        System.out.println("TreeMap 2:");
        final Map<Integer, Integer> m22 = new TreeMap<>(Collections.reverseOrder());
        IntStream.range(1, 5).forEach(v -> m22.put(v, v * 2));
        m22.forEach((key, value) -> System.out.println(key + "-" + value));

        System.out.println("LinkedHashMap:");
        final Map<Integer, Integer> m3 = new LinkedHashMap<>();
        IntStream.of(1, 3, 5, 4, 2).forEach(v -> m3.put(v, v * 2));
        m3.forEach((key, value) -> System.out.println(key + "-" + value));
    }

    private void chQueues() {
        Stack<Integer> s1 = new Stack<>(); // use Deque instead

        // If you need add/remove of the both ends,
        // ArrayDeque is significantly better than a linked list.
        // Random access each element is also O(1) for a cyclic queue.
        // The only better operation of a linked list is removing the current element during iteration.

        Queue<Integer> q1 = new LinkedList<>();
        IntStream.of(1, 3, 5, 4, 2).forEach(q1::add);
        q1.peek(); // get, don't remove
        q1.poll(); // get and remove
        q1.element(); // same as peek but throws exc if q empty
        q1.offer(7); // same as add but does not throw exc if no capacity

        Deque<Integer> d1 = new LinkedList<>();
        d1.poll(); // get and remove head
        d1.pollFirst(); // same as poll
        d1.pollLast(); // polls tail
        d1.addFirst(1); // inserts as head
        d1.addLast(1); // inserts to tail

        System.out.println("PriorityQueue:");
        Queue<Integer> q2 = new PriorityQueue<>();
        IntStream.of(1, 1, 5, 1, 5).forEach(q2::add);
        while (!q2.isEmpty()) {
            System.out.println(q2.poll());
        }

        System.out.println("PriorityQueue 2:");
        Queue<Integer> q3 = new PriorityQueue<>(Comparator.reverseOrder());
        IntStream.of(1, 1, 5, 1, 5).forEach(q3::add);
        while (!q3.isEmpty()) {
            System.out.println(q3.poll());
        }
    }

    public static int binarySearch(int[] nums, int target) {
        final int l = nums.length;

        if (target < nums[0] || target > nums[l - 1]) {
            return -1;
        }

        int leftIdx = 0, rightIdx = l - 1, pivotIdx = l / 2;
        if (l % 2 == 0) {
            pivotIdx--;
        }

        while (true) {
            if (target == nums[pivotIdx]) {
                return pivotIdx;
            } else {
                if (target > nums[pivotIdx]) { // search right
                    leftIdx = pivotIdx + 1;
                    pivotIdx += (rightIdx - pivotIdx) / 2 + 1;
                } else { // search left
                    rightIdx = pivotIdx - 1;
                    pivotIdx -= (pivotIdx - leftIdx) / 2 + 1;
                }

                if (rightIdx == pivotIdx + 1 || leftIdx == pivotIdx - 1) {
                    if (target == nums[pivotIdx]) {
                        return pivotIdx;
                    } else if (pivotIdx + 1 < l && target == nums[pivotIdx + 1]) {
                        return pivotIdx + 1;
                    } else if (pivotIdx - 1 >= 0 && target == nums[pivotIdx - 1]) {
                        return pivotIdx - 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    public static int binarySearch(int[] nums, int target, int leftIdx, int rightIdx) {
        final int l = rightIdx - leftIdx + 1;

        if (target < nums[leftIdx] || target > nums[rightIdx]) {
            return -1;
        }

        int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;
        if (l % 2 == 0) {
            pivotIdx--;
        }

        while (true) {
            if (target == nums[pivotIdx]) {
                return pivotIdx;
            } else {
                if (target > nums[pivotIdx]) { // search right
                    leftIdx = pivotIdx + 1;
                    pivotIdx += (rightIdx - pivotIdx) / 2 + 1;
                } else { // search left
                    rightIdx = pivotIdx - 1;
                    pivotIdx -= (pivotIdx - leftIdx) / 2 + 1;
                }

                if (rightIdx == pivotIdx + 1 || leftIdx == pivotIdx - 1) {
                    if (target == nums[pivotIdx]) {
                        return pivotIdx;
                    } else if (pivotIdx + 1 <= l && target == nums[pivotIdx + 1]) {
                        return pivotIdx + 1;
                    } else if (pivotIdx - 1 >= 0 && target == nums[pivotIdx - 1]) {
                        return pivotIdx - 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        final BootCamp bootCamp = new BootCamp();
        bootCamp.ch4();
        bootCamp.ch5();
        bootCamp.ch6();
        bootCamp.ch7();
        bootCamp.chMaps();
        bootCamp.chQueues();
    }
}
