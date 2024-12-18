import com.LinkedListQueue;
import com.MyQueue;

public class ED197 {

    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
        MyQueue<Integer> mergedQueue = new LinkedListQueue<Integer>();
        int lastdequeue = 0;
        int ai = a.dequeue();
        int bj = b.dequeue();

        while (!a.isEmpty() || !b.isEmpty()) {

            if (lastdequeue == 1 && !a.isEmpty()) {
                ai = a.dequeue();
            } else if (lastdequeue == 2 && !b.isEmpty()) {
                bj = b.dequeue();
            } else if (lastdequeue == 3) {
                if (!a.isEmpty()) {
                    ai = a.dequeue();
                }
                if (!b.isEmpty()) {
                    bj = b.dequeue();
                }
            }
            if (ai > bj && bj != 0) {
                mergedQueue.enqueue(bj);
                bj = 0;
                lastdequeue = 2;
            } else if (ai < bj && ai != 0) {
                mergedQueue.enqueue(ai);
                ai = 0;
                lastdequeue = 1;
            } else {
                if (bj != 0) mergedQueue.enqueue(bj);
                if (ai != 0) mergedQueue.enqueue(ai);
                ai = 0;
                bj = 0;
                lastdequeue = 3;
            }
        }

        if (!a.isEmpty()) {
            while (!a.isEmpty()) {
                mergedQueue.enqueue(a.dequeue());
            }

        } else if (!b.isEmpty()) {
            while (!b.isEmpty()) {
                mergedQueue.enqueue(b.dequeue());
            }

        } else if (ai != 0) {
            mergedQueue.enqueue(ai);

        } else if (bj != 0) {
            mergedQueue.enqueue(bj);

        }

        return mergedQueue;
    }
}
