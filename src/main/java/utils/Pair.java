package utils;

/**
 * A generic record that holds a key-value pair.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 * @param key the key of the pair
 * @param value the value of the pair
 */
public record Pair<K, V>(K key, V value) {
}