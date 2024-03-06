package concurrent;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by cdlvsheng on 2016/4/4.
 */
public class CountFileTask extends RecursiveTask<Integer> {
	
	private File file;
	
	public CountFileTask(File f) {
		this.file = f;
	}
	
	@Override
	protected Integer compute() {
		int    sum  = 0;
		File[] list = file.listFiles();
		
		for (File f : list) {
			if (f.isDirectory()) {
				CountFileTask cft = new CountFileTask(f);
				cft.fork();
				sum += cft.join();
			} else {
				try {
					if (!f.getName().endsWith(".java")) {
						continue;
					}
					sum += IOUtils.readLines(new FileInputStream(f)).size();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sum;
	}
	
	// 串行计算， dfs
	public Integer computeSerial(File file) {
		int    sum  = 0;
		File[] list = file.listFiles();
		
		for (File f : list) {
			if (f.isDirectory()) {
				sum += computeSerial(f);
			} else {
				try {
					if (!f.getName().endsWith(".java")) {
						continue;
					}
					sum += IOUtils.readLines(new FileInputStream(f)).size();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool    forkJoinPool = new ForkJoinPool();
		CountFileTask   task         = new CountFileTask(new File("/Users/lvsheng1/work/gitlab"));
		long            start        = System.currentTimeMillis();
		Future<Integer> result       = forkJoinPool.submit(task);
		try {
			Integer integer  = result.get();
			long    duration = System.currentTimeMillis() - start;
			System.out.println("parallel time cost: " + duration + " ms, result: " + integer);
			
			start = System.currentTimeMillis();
			Integer sum = task.computeSerial(new File("/Users/lvsheng1/work/gitlab"));
			duration = System.currentTimeMillis() - start;
			System.out.println("serial time cost: " + duration + " ms, result: " + sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}