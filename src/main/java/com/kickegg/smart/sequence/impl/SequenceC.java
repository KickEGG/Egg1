package com.kickegg.smart.sequence.impl;

import com.kickegg.smart.sequence.ClientThread;
import com.kickegg.smart.sequence.MyThreadLocal;
import com.kickegg.smart.sequence.Sequence;

public class SequenceC implements Sequence {
    private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
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
        Sequence sequence = new SequenceC();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
