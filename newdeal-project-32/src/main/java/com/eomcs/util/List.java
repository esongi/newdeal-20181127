package com.eomcs.util;

public interface List<E> {

  // 인터페이스는 모두 공개, abstract

  E[] toArray(E[] a);

  void add(E obj);

  E get(int index);

  E set(int index, E obj);

  E remove(int index);

  int size();
}
