package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;

  public Queue() {
    maxSize = 100;
  }

  public Queue(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Queue<E>) temp;
  }

  public void offer(E value) {
    if (size() == maxSize)
      remove(0); // 꽉차면 맨 앞에 입력된 값을 제거한다.
    add(value);
  }

  // 맨 앞에 있는 걸 땡긴다
  public E poll() {
    if (size() > 0)
      return remove(0);
    return null;
  }

  public Iterator<E> iterator() {
    // 큐에서 값을 꺼내줌.큐에서 복제해서 같이, 이터레이터는 쓴것을 다시 사용하지 않음
    // object 클래스의 생성자
    return new Iterator<>() {
      Queue<?> queue;
      int count;

      { // 인스턴스 블럭
        // 생성자가 생성되기 전에 생성, new 할때마다 생성
        // 바깥클래스를 명시해야함
        // 안쪽클래스 = 바깥클래스의 this
        this.queue = Queue.this.clone();
      }

      @Override
      public boolean hasNext() {
        return this.count < Queue.this.size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        this.count++;
        return (E) queue.poll();
      }
    };
  }
  
}
