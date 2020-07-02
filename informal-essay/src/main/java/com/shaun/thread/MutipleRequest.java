package com.shaun.thread;

import java.util.concurrent.*;

public class MutipleRequest {

    public static class OCRAbortPolicy implements RejectedExecutionHandler {
        /**
         * Creates an {@code AbortPolicy}.
         */
        public OCRAbortPolicy() { }

        /**
         * Always throws RejectedExecutionException.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         * @throws RejectedExecutionException always
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        }
    }

    private static final RejectedExecutionHandler defaultHandler = new OCRAbortPolicy();

    static ExecutorService pool = new ThreadPoolExecutor(1, 1,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(5),
            Executors.defaultThreadFactory(), defaultHandler);

    public static void main(String[] args) {

        int count = 0;
        try{
            for (int i = 0; i < 50; i++) {
                final int ii = i;

                if(count < 6){
                    count++;
                    pool.submit(() -> {
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return Thread.currentThread().getName() + "=>" + ii;
                    });
                }else{
                    System.out.println("稍后重试！");
                }



//                while(!future.isDone()) {
//                    System.out.println("Calculating...");
//                    Thread.sleep(300);
//                }
//                if(future.isDone()){
//                    System.out.println(future.get());
//                }

//                if(null != value){
//                    System.out.println(value.get());
//                }
//                Thread.sleep(50L);
//                System.out.println("==="+value.get());
            }
        }catch (RejectedExecutionException ex){
            System.out.println("当前系统忙碌，稍后重试！");
        }
//        catch (InterruptedException ex2){
//            ex2.printStackTrace();
//        }
//        catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
