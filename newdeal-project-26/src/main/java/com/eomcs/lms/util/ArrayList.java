package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<T> {
  // 리스트일경우는 E를 더 많이 씀, Element
  // 제네릭은 배열에는 적용 불가 ex) WhatType[], 파라미터만 가능
  final int DEFAULT_CAPACITY = 10;

  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    // 메서드 해석하자
    // a의 0번째
    System.arraycopy(list, 0, a, 0, size);
    if (a.length < size) {
      return (T[]) Arrays.copyOf(list, size, a.getClass());
    }
    
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  public void add(T item) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    list[size++] = item;
  }

  // 사이즈 확인, 배열을 만들수 있다(핸들러)
  public int size() {
    return this.size;
  }
}
