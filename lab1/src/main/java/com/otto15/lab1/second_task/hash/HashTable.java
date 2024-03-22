package com.otto15.lab1.second_task.hash;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<V> {
    private ArrayList<HashNode<V> > bucketArray;

    private int bucketsNumber;

    private int size;

    public HashTable()
    {
        bucketArray = new ArrayList<>();
        bucketsNumber = 12;
        size = 0;

        for (int i = 0; i < bucketsNumber; i++)
            bucketArray.add(null);
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return getSize() == 0; }

    private final int hashCode(V value) {
        return Objects.hashCode(value);
    }

    private int getBucketIndex(V value)
    {
        int hashCode = hashCode(value);
        int index = hashCode % bucketsNumber;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(V value)
    {
        int bucketIndex = getBucketIndex(value);
        int hashCode = hashCode(value);

        HashNode<V> head = bucketArray.get(bucketIndex);

        HashNode<V> prev = null;
        while (head != null) {
            if (head.value == value) {
                break;
            }

            if (head.value.equals(value) && hashCode == head.hashCode)
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;


        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    public V find(V value)
    {
        int bucketIndex = getBucketIndex(value);
        int hashCode = hashCode(value);

        HashNode<V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.value == value) {
                return head.value;
            }

            if (head.value.equals(value) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        return null;
    }

    public void add(V value)
    {
        int bucketIndex = getBucketIndex(value);
        int hashCode = hashCode(value);
        HashNode<V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.value == value) {
                return;
            }

            if (head.value.equals(value) && head.hashCode == hashCode) {
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<V> newNode
                = new HashNode<V>(value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        if ((1.0 * size) / bucketsNumber >= 0.7) {
            ArrayList<HashNode<V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            bucketsNumber = 2 * bucketsNumber;
            size = 0;
            for (int i = 0; i < bucketsNumber; i++)
                bucketArray.add(null);

            for (HashNode<V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    static final class HashNode<V> {
        V value;
        final int hashCode;

        HashNode<V> next;

        public HashNode(V value, int hashCode)
        {
            this.value = value;
            this.hashCode = hashCode;
        }
    }
}
