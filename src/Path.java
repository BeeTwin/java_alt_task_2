import java.awt.*;

public class Path {
    public Point point;
    public Path previous;

    public Path(Point point) {
        this.point = point;
    }

    public Path(Point point, Path previous) {
        this(point);
        this.previous = previous;
    }
}
