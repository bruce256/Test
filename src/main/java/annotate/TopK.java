package annotate;

/**
 * @author LvSheng
 * @date 2020/2/21
 **/
public class TopK {
	
	public static void main(String[] args) {
		TopK top = new TopK();
		int  kthLargest = top.findKthLargest(new int[]{2, 1}, 2);
		System.out.println(kthLargest);
		 kthLargest = top.findKthLargest(new int[]{-1, 2, 0}, 2);
		System.out.println(kthLargest);
		
	}
	
	public int findKthLargest(int[] nums, int k) {
		if (nums.length < k || k <= 0) return 0;
		
		// 构建堆， 小顶堆
		int[] minHeap = new int[k];
		for (int i = 0; i < k; i++) {
			minHeap[i] = nums[i];
			siftUp(minHeap, i);
		}
		
		// 维护堆
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > minHeap[0]) {
				minHeap[0] = nums[i];
				siftDown(minHeap);
			}
		}
		
		return minHeap[0];
	}
	
	// 最后一个元素上移
	private void siftUp(int[] heap, int pos) {
		int parent = (pos - 1) / 2;
		while (heap[pos] < heap[parent] && pos > 0) {
			swap(heap, parent, pos);
			pos = parent;
			parent = (parent - 1) / 2;
		}
	}
	
	// 最顶元素下移
	private void siftDown(int[] heap) {
		int pos = 0;
		while (pos < heap.length) {
			int left  = pos * 2 + 1;
			int right = pos * 2 + 2;
			int min   = left;
			
			// 找到最小的孩子
			if (right < heap.length && heap[right] < heap[left]) min = right;
			if (min < heap.length && heap[min] < heap[pos]) {
				swap(heap, pos, min);
				pos = min;
			} else break;
		}
	}
	
	private void swap(int[] heap, int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
