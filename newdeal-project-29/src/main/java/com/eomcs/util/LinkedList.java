package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  // 배열은 처음부터 크기를 지정해줘야함
  private Node<E> first;
  private Node<E> last;
  private int size;

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    E[] arr = (E[]) Array.newInstance(a.getClass().getComponentType(), size);
    Node<E> node = first;
    for (int i = 0; i < size; i++) {
      arr[i] = node.value;
      node = node.next;
    }
    return arr;
  }

  public void add(E obj) {
    Node<E> prev = last;
    last = new Node<>(prev, obj, null);
    if (prev == null) {
      first = last;
    } else {
      prev.next = last;
    }
    // 크기 증가
    size++;
  }

  public E get(int index) {
    // 범위 안에 값이 아닌 경우
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> node = first;
    for (int i = 1; i <= index; i++) {
      node = node.next;
    }
    return node.value;
  }

  public E set(int index, E obj) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> node = first;

    for (int i = 1; i <= index; i++) {
      node = node.next;
    }
    E oldValue = node.value;
    node.value = obj;

    return oldValue;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> node = first;
    for (int i = 1; i <= index; i++) {
      node = node.next;
    }

    if (first == last) {
      first = last = null;
    } else if (node == first) {
      first = node.next;
    } else if (node == last) {
      last = node.prev;
    } else {
      node.prev.next = node.next;
    }

    // 하나의 객체를 생성해서 값을 넣어주고
    E oldValue = node.value;

    // help Gc
    // 원래 그 값과 이전 이후를 비운후
    node.value = null;
    node.next = null;
    node.prev = null;

    // 사이즈를 줄이고
    size--;

    // 넣어줬던 값으로 리턴
    return oldValue;
  }

  public int size() {
    return size;
  }

  private static class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;

    // 생성자 추가
    Node(Node<E> prev, E value, Node<E> next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
  }

  /*
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");

    print(list);

    System.out.println(list.get(0));
    // System.out.println(list.set(0, "xxx"));
    // System.out.println(list.set(2, "xxx"));
    // System.out.println(list.remove(0));
    // System.out.println(list.remove(2));

    print(list);
  }

  private static void print(LinkedList<String> ll) {
    String[] values = ll.toArray(new String[] {});
    System.out.println("------------");
    for (String value : values) {
      System.out.println(value);
    }
    System.out.println("---------------------");
  }
  
  */
}
