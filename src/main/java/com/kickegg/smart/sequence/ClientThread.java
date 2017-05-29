package com.kickegg.smart.sequence;

public class ClientThread extends Thread {
    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    // demo测试1条线程运行3次
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "=>" +
                    sequence.getNumber());
        }
    }
}
