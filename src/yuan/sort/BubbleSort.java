package yuan.sort;

/**
 * @author liuyiyuan
 * <p>
 * 冒泡排序
 * 从序列的一端开始往另一端冒泡（可以从左往右冒泡，也可以从右往左冒泡），依次比较相邻的两个数的大小（可以比大或是比小）。
 * <p>
 * 冒泡的末端会逐渐变得有序
 * <p>
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)   (原地排序)
 * <p>
 * 稳定
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {
        sort0(arr);
    }


    private static void sort0(Comparable[] arr) {
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

    /**
     * 比较两个数，v1是否小于v2
     */
    private static boolean less(Comparable v1, Comparable v2) {
        return v1.compareTo(v2) < 0;
    }


    /**
     * 交换数组的两个值
     */
    private static void exch(Comparable[] arr, int i, int j) {
        if (i == j) return;
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("交换位置的元素索引越界！");
        }
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    /**
     * 单行打印数组
     */
    public static void show(Comparable[] arr){
        if(arr==null) throw new IllegalArgumentException("数组不能为null");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {28, 9, 2, 5, 17, 45, 1, 7, 0, 2, 8, 9, 23};
        sort(a);
        show(a);
    }
}
