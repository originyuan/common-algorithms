package yuan.sort.no02_select;

import yuan.sort.Sort;

/**
 * @author liuyiyuan
 * <p>
 * 选择排序
 * <p>
 * 首先，找到数组中最小的元素，拎出来，将它和数组的第一个元素交换位置，
 * 第二步，在剩下的元素中继续寻找最小的元素，拎出来，和数组的第二个元素交换位置，
 * 如此循环，直到整个数组排序完成。
 * 至于选大还是选小，这个都无所谓，你也可以每次选择最大的拎出来排，也可以每次选择最小的拎出来的排，只要你的排序的手段是这种方式，都叫选择排序。
 *
 * 时间复杂度 O(n^2)
 */
public class SelectSort extends Sort {
    public static SelectSort instance = new SelectSort();

    private SelectSort() {
    }

    @Override
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {28, 9, 2, 5, 17, 45, 1, 7, 0, 2, 8, 9, 23};
        SelectSort.instance.sort(a);
        SelectSort.instance.show(a);
    }

}
