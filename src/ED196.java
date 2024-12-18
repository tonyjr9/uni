import com.*;

public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        String name, queue;
        while (!q.isEmpty()) {
            name = q.dequeue();
            queue = q.dequeue();
            switch (queue) {
                case "A":
                    a.enqueue(name);

                    break;
                case "B":
                    b.enqueue(name);
                    break;
                case "X":
                    if (a.size() > b.size()) {
                        b.enqueue(name);
                    } else if (a.size() < b.size()) {
                        a.enqueue(name);
                    }

                    break;
            }
        }

    }
}
