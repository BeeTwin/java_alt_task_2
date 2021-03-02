import java.awt.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PathFinder {
    public Maze maze;

    public PathFinder(Maze maze) {
        this.maze = maze;
    }

    public Path findPath() throws PathNotFoundException {
        Set<Point> visited = new HashSet<>();
        Queue<Path> queue = new ArrayDeque<>();
        queue.add(new Path(maze.start));

        while(!queue.isEmpty()) {
            Path current = queue.remove();

            if(current.point.equals(maze.finish))
                return current;

            if(visited.contains(current.point) || !maze.canStep(current.point.x, current.point.y))
                continue;

            visited.add(current.point);

            for (int dy = -1; dy <= 1; dy++)
                for (int dx = -1; dx <= 1; dx++)
                    if ((Math.abs(dx) + Math.abs(dy)) == 1)
                        queue.add(new Path(new Point(current.point.x + dx, current.point.y + dy), current));
        }
        throw new PathNotFoundException();
    }
}
