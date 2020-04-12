package com.javarush.task.task17.task1713;

/* 
Общий список
*/

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Solution implements List <Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {
        List<Long> list = new Solution();
        Solution downcasting = (Solution) list;
        downcasting.original.add(10L);
    }

    public void trimToSize() {
        original.trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        original.ensureCapacity(minCapacity);
    }

    @Override
    public int size() {
        return original.size();
    }

    @Override
    public boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public Object clone() {
        return original.clone();
    }

    @Override
    public Object[] toArray() {
        return original.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return original.toArray(a);
    }

    @Override
    public Long get(int index) {
        return original.get(index);
    }

    @Override
    public Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    public boolean add(Long aLong) {
        return original.add(aLong);
    }

    @Override
    public void add(int index, Long element) {
        original.add(index, element);
    }

    @Override
    public Long remove(int index) {
        return original.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        return original.equals(o);
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean remove(Object o) {
        return original.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        original.clear();
    }

    @Override
    public boolean addAll(Collection<? extends Long> c) {
        return original.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Long> c) {
        return original.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return original.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return original.retainAll(c);
    }

    @Override
    public ListIterator<Long> listIterator(int index) {
        return original.listIterator(index);
    }

    @Override
    public ListIterator<Long> listIterator() {
        return original.listIterator();
    }

    @Override
    public Iterator<Long> iterator() {
        return original.iterator();
    }

    @Override
    public List<Long> subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        original.forEach(action);
    }

    @Override
    public Spliterator<Long> spliterator() {
        return original.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super Long> filter) {
        return original.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<Long> operator) {
        original.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Long> c) {
        original.sort(c);
    }
}
