package yuan.sort;

/**
 * @author liuyiyuan
 *
 *
 * 排序模板类
 */
public abstract class Sort {
    public abstract void sort(Comparable[] arr);

    /**
     * 比较两个数，v1是否小于v2
     */
    public boolean less(Comparable v1, Comparable v2) {
        return v1.compareTo(v2) < 0;
    }

    /**
     * 交换数组的两个值
     */
    public void exch(Comparable[] arr, int i, int j) {
        if(i==j) return;
        if(i<0||j<0||i>=arr.length||j>=arr.length){
            throw new ArrayIndexOutOfBoundsException("交换位置的元素索引越界！");
        }
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 判断是否有序，默认从小到大
     */
    public boolean isSorted(Comparable[] arr) {
        if(arr == null) return false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单行打印数组
     */
    public void show(Comparable[] arr){
        if(arr==null) throw new IllegalArgumentException("数组不能为null");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
