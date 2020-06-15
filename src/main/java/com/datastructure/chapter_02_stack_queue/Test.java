package com.datastructure.chapter_02_stack_queue;

import java.util.Random;

/**
 * @date : 2019-10-30
 */
public class Test {

    public static void testStack(){
        ArrayStack as  = new ArrayStack();
        System.out.println(as.toString());
        for(int i = 0; i < 10 ; i++) {
            Integer in = Integer.valueOf(i);
            as.push(in);
            System.out.println(as.toString());
        }

        for(int i = 0; i < 10 ; i++) {
            //Integer in = Integer.valueOf(i);
            as.pop();
            System.out.println(as.toString());
        }
    }


    public static void testQueue(){
        ArrayQueue aq = new ArrayQueue();
        System.out.println(aq.toString());
        for(int i = 0; i < 20 ; i++) {
            Integer in = Integer.valueOf(i);
            aq.enqueue(in);
            System.out.println(aq.toString());
        }

        for(int i = 0; i < 20 ; i++) {
            //Integer in = Integer.valueOf(i);
            aq.dequeue();
            System.out.println(aq.toString());
        }
    }

    public static double testQueueComparison(Queue<Integer> q, int count){
        long start = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < count ;i ++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i < count ;i ++){
            q.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    public static void main(String[] args) {
       // testStack();
       //   testQueue();
        int count = 1000000;
      /*  double time1 = testQueueComparison(new ArrayQueue<Integer>(),count);
        System.out.println("ArrayQueue, time: " + time1 + " s");*/
        double time2 = testQueueComparison(new LoopQueue<Integer>(),count);
        System.out.println("LoopQueue, time: " + time2 + " s");
        double time3 = testQueueComparison(new LoopQueueWithoutWaste<Integer>(),count);
        System.out.println("LoopQueueWithoutWaste, time: " + time3 + " s");
    }
}
