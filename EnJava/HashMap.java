import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class HashMap<K, V> {
  public class Entry<K, V> {
      K key;
      V value;
      Entry<K, V> next;
      Entry(K key, V value) {
          this.key = key;
          this.value = value;
          this.next = null;
      }
      @Override
      public String toString() {
          return key + "=" + value;
      }
  }
  private LinkedList<Entry<K, V>>[] buckets;
  private static final int INITIAL_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.75;
  private int size = 0;
  @SuppressWarnings("unchecked")
  public HashMap() {
      buckets = new LinkedList[INITIAL_CAPACITY];
      for (int i = 0; i < INITIAL_CAPACITY; i++) {
          buckets[i] = new LinkedList<>();
      }
  }
  private int getBucketIndex(K key) {
      int hashCode = key.hashCode();
      return Math.abs(hashCode) % buckets.length;
  }
  public void put(K key, V value) {
      if ((double) size / buckets.length >= LOAD_FACTOR) {
          resize();
      }
      int bucketIndex = getBucketIndex(key);
      for (Entry<K, V> entry : buckets[bucketIndex]) {
          if (entry.key.equals(key)) {
              entry.value = value;
              return;
          }
      }
      buckets[bucketIndex].add(new Entry<>(key, value));
      size++;
  }
  public V get(K key) {
      int bucketIndex = getBucketIndex(key);
      for (Entry<K, V> entry : buckets[bucketIndex]) {
          if (entry.key.equals(key)) {
              return entry.value;
          }
      }
      return null;
  }
  public V remove(K key) {
      int bucketIndex = getBucketIndex(key);
      Iterator<Entry<K, V>> iterator = buckets[bucketIndex].iterator();
      while (iterator.hasNext()) {
          Entry<K, V> entry = iterator.next();
          if (entry.key.equals(key)) {
              iterator.remove();
              size--;
              return entry.value;
          }
      }
      return null;
  }
  public int size() {
      return size;
  }
  public boolean isEmpty() {
      return size == 0;
  }
  @SuppressWarnings("unchecked")
  private void resize() {
      LinkedList<Entry<K, V>>[] oldBuckets = buckets;
      buckets = new LinkedList[oldBuckets.length * 2];
      for (int i = 0; i < buckets.length; i++) {
          buckets[i] = new LinkedList<>();
      }
      size = 0;
      for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
          if (bucket != null) {
              for (Entry<K, V> entry : bucket) {
                  put(entry.key, entry.value);
              }
          }
      }
  }
  public Set<Entry<K, V>> entrySet() {
      Set<Entry<K, V>> entries = new HashSet<>();
      for (int i = 0; i < buckets.length; i++) {
          for (Entry<K, V> entry : buckets[i]) {
              entries.add(entry);
          }
      }
      return entries;
  }
}


