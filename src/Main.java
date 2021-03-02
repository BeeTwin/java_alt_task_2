import java.awt.*;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileWorker fw = new FileWorker();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter path: ");
        String txt = in.nextLine();
        String[] lines = fw.readAllLines(txt);
        /*String[] lines = {
            "############",
            "#.#......#.#",
            "#..s#..#.#.#",
            "#.#####....#",
            "#..#....##.#",
            "#..#.#.##..#",
            "#....#.#..##",
            "######...###",
            "#......#..f#",
            "############"
        };*/
        Tile[][] tiles = Parser.parse(lines);
        Maze maze = new Maze(tiles);
        PathFinder pf = new PathFinder(maze);
        try {
            Path path = pf.findPath();
            while(path.previous.previous != null) {
                Point current = path.previous.point;
                tiles[current.x][current.y] = Tile.PATH;
                path = path.previous;
            }
            fw.writeAllLines(Output.Prepare(tiles), txt);
        } catch (PathNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
