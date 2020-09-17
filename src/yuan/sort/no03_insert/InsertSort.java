package yuan.sort.no03_insert;

import yuan.sort.Sort;

/**
 * @author liuyiyuan
 * <p>
 * 插入排序
 * <p>
 * 后面的元素依次与前面的元素比较，（假设从小到大排序），小于前面相邻元素则交换位置，继续与前面比较，知道遇见比自己小的元素，或到达索引0位置
 * <p>
 * 时间复杂度 O(n^2)
 */
public class InsertSort extends Sort {
    public static InsertSort instance = new InsertSort();

    private InsertSort() {
    }

    @Override
    public void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] a = {28, 9, 2, 5, 17, 45, 1, 7, 0, 2, 8, 9, 23};
        InsertSort.instance.sort(a);
        InsertSort.instance.show(a);

    }
}
