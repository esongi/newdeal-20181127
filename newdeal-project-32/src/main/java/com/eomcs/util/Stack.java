package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {
  // 클론 인터페이스, 링크드리스트 상속
  private int maxSize;

  public Stack() {
    maxSize = 100;
  }

  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public Stack<E> clone() {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Stack<E>) temp;
  }

  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }

  public E pop() {
    return remove(size() - 1);
  }

  public Iterator<E> iterator() {

    return new Iterator<>() {
      // 그냥 주면 원본의 데이터가 pop 할때 날아가기 때문에, 복제해서 넘겨줘라
      // 익명클래스는 생성자가 존재x
      // super 클래스의 기본 생성자를 ?
      Stack<?> stack;
      int count;

      { // 인스턴스 블럭
        // 생성자가 생성되기 전에 생성, new 할때마다 생성
        // 바깥클래스를 명시해야함
        // 안쪽클래스 = 바깥클래스의 this
        this.stack = Stack.this.clone();
      }

      @Override
      public boolean hasNext() {
        return this.count < Stack.this.size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        this.count++;
        return (E) stack.pop();
      }
    };
  }

}
