package com.kickegg.smart.sequence.impl;

import com.kickegg.smart.sequence.ClientThread;
import com.kickegg.smart.sequence.Sequence;

/**
 * 测试类
 * 这里引入"线程局部变量"
 */
public class SequenceB implements Sequence {
    // ThreadLocal<?>这里要用包装类
    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        // 这里用set实现增量处理
        numberContainer.set(numberContainer.get()-1);
        return numberContainer.get();
    }

    public static void main(String[] args){
        Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
