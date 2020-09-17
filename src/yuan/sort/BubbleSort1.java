package yuan.sort;

/**
 * @author liuyiyuan
 * <p>
 * 冒泡排序
 * 从序列的一端开始往另一端冒泡（可以从左往右冒泡，也可以从右往左冒泡），依次比较相邻的两个数的大小（可以比大或是比小）。
 *
 * 冒泡的末端会逐渐变得有序
 *
 * 时间复杂度 O(n^2)
 */
public final class BubbleSort1 extends Sort {

    public static BubbleSort1 instance = new BubbleSort1();

    private BubbleSort1() {
    }

    @Override
    public void sort(Comparable[] arr) {
//        sortV1(arr);
//        sortV2(arr);
        sortV3(arr);
    }

    private void sortV1(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                }
            }
        }
    }

    private void sortV2(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void sortV3(Comparable[] arr) {
        int bound;
        int t = arr.length - 1;
        for (int i = 0; i < arr.length - 1 && t != 0; i++) {
            bound = t;
            t = 0;
            for (int j = 0; j < bound; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                    t = j;
                }
            }
        }
    }


    public static void main(String[] args) {
//        Integer[] a = {2, 5, 1, 7, 0, 2, 8, 9, 23};
        Integer[] a = {28, 9, 2, 5, 17, 45, 1, 7, 0, 2, 8, 9, 23};
        BubbleSort1.instance.sort(a);
        BubbleSort1.instance.show(a);
    }
}
