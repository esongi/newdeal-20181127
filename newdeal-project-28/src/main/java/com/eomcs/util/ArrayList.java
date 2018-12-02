package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<T> {
  final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size = 0;

  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      elementData = new Object[initialCapacity];
    else
      elementData = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }

  public void add(T obj) {
    if (size >= elementData.length) {
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      elementData = Arrays.copyOf(elementData, newCapacity);
    }

    elementData[size++] = obj;
  }

  // 값을 얻어와 적용시키므로 리턴타입! 리턴타입은 제네릭 T
  // 목록(배열)의 특정 항목[index]이므로, 메서드와 리턴 타입은 동일
  @SuppressWarnings("unchecked")
  public T get(int index) {
    // 목록에서 특정 항목의 값을 꺼내주는 get()을 정의한다.
    if (index < 0 || index >= size) {
      return null;
    }
    return (T) elementData[index];

  }

  public T set(int index, T obj) {
    // 목록의 항목 값을 바꾸는 set()을 정의한다.
    if (index < 0 || index >= size) {
      return null;
    }

    // 목록의 항목 값을 저장하고
    // 바꾸고 싶은 값으로 덮어쓴 다음
    // 바뀐 값으로 리턴
    @SuppressWarnings("unchecked")
    T old = (T) elementData[index];
    elementData[index] = obj;
    return old;
  }

  public T remove(int index) {
    // 목록에서 특정 항목의 값을 삭제하는 remove()를 정의한다.

    if (index < 0 || index >= size) {
      return null;
    }

    @SuppressWarnings("unchecked")
    T old = (T) elementData[index];

    int newSize = size - 1;
    System.arraycopy(elementData, index + 1, elementData, index, newSize);
    elementData[size = newSize] = null;
    return old;
  }

  public int size() {
    return size;
  }

}
