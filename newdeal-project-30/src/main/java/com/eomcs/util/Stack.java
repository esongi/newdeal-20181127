package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;

  public Stack() {
    maxSize = 100;
  }

  // 오버로딩
  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public Stack<E> clone() {
    // Stack 생성
    Stack<E> temp = new Stack<>();

    // 만들어진 사이즈만큼 값을 추가
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    // 리턴하기 전 강제 형변환
    // 이렇게 클론을 재정의하는 이유는
    // 오브젝트 클론이 아니라, stack 클래스의 객체를 복제하기 위해서?
    return (Stack<E>) temp;
  }

  public void push(E value) {
    if (size() == maxSize) {
      remove(0);
    }
    add(value);
  }

  public E pop() {
    return remove(size() - 1);
  }
  /*
   * public static void main(String[] args) { Stack<String> stack = new Stack<>();
   * stack.push("aaa"); stack.push("bbb"); stack.push("ccc"); stack.push("aaa"); stack.push("bbb");
   * stack.push("ccc");
   * 
   * Stack<String> temp1 = stack.clone(); System.out.println(stack.size()); while (stack.size() > 0)
   * { System.out.println(stack.pop()); } System.out.println("-----------");
   * 
   * // 뽑아버리면 다시 돌아오지 못함! System.out.println(stack.size()); Stack<String> temp2 = stack.clone();
   * while (temp2.size() > 0) { System.out.println(temp2.pop()); } }
   */
}
