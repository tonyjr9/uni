import java.text.DecimalFormat;

public class Rectangle {
    // variaveis a ser usadas para guardar os valores necessarios
    int d1, d2; //representam o tamanho dos lados do retangulo
    int x1, y1, x2, y2;
    Point P1, P2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.d1 = Math.abs(y2 - y1);
        this.d2 = Math.abs(x2 - x1);
        this.P1 = new Point(x1, y1);
        this.P2 = new Point(x2, y2);
    }

    Rectangle(Point p1, Point p2) {
        this.P1 = p1;
        this.P2 = p2;
        this.x1 = P1.x;
        this.y1 = P1.y;
        this.x2 = P2.x;
        this.y2 = P2.y;
        this.d1 = Math.abs(y2 - y1);
        this.d2 = Math.abs(x2 - x1);
    }

    public int area() {
        return d1 * d2;
    }

    public int perimeter() {
        return (d1 + d2) * 2;
    }

    public boolean pointInside(Point p) {
        return Math.min(x1, x2) <= p.x && Math.max(x1, x2) >= p.x && Math.min(y1, y2) <= p.y && Math.max(y1, y2) >= p.y;
    }

    public boolean rectangleInside(Rectangle r) {
        return pointInside(r.P1) && pointInside(r.P2);
    }
}
