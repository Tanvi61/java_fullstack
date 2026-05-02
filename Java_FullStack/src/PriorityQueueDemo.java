import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(101);
		pq.add(190);
		pq.add(170);
		pq.add(180);
		System.out.println(pq);
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.isEmpty());
		System.out.println(pq.offer(160));
		System.out.println(pq.contains(110));
	}

}
