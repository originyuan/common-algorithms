package yuan.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuyiyuan
 *
 *
 * LUR缓存实现：
 * 1、使用LinkedHashMap实现
 * 2、使用链表加Map实现
 *
 */
public class LRUCache<K, V> {

    private static final int CACHE_SIZE = 10;
    private LinkedHashMap<K, V> lrucache = new LinkedHashMap<K, V>(10, 0.75F, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            System.out.println("当前最旧的元素为：key-"+eldest.getKey()+", val-"+eldest.getValue());
            return this.size()>CACHE_SIZE;
        }
    };

    public void put(K key, V value){
        lrucache.put(key, value);
    }

    public V get(K key){
        return lrucache.get(key);
    }

    public int size(){
        return lrucache.size();
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>();
        for(int i=0; i<=20; i++){
            lruCache.put(i, i);
        }
        System.out.println(lruCache.size());
        lruCache.get(0);
        lruCache.put(45, 45);
    }
}
