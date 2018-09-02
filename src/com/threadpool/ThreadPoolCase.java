package com.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCase {
	
	private  static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	
	public static void main(String[] args) {
		Future<String> future = executor.submit(new Task());
		try {
			String result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class Task implements Callable<String>{

		@Override
		public String call() throws Exception {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "this is a future case";
		}
		
	}

}
