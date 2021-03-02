import java.awt.*;

public class Maze {
    public Tile[][] tiles;
    public Point start;
    public Point finish;

    public Maze(Tile[][] tiles) {
        this.tiles = tiles;
        Tile tile;
        for(int i = 0; i < tiles.length; i++)
            for(int j = 0; j < tiles[0].length; j++)
                if((tile = tiles[i][j]).equals(Tile.START))
                    start = new Point(i, j);
                else if (tile.equals(Tile.FINISH))
                    finish = new Point(i, j);
    }

    public boolean canStep(Point point) {
        Tile tile;
        boolean canStep;
        if(canStep = isWithin(point)) {
            tile = tiles[point.x][point.y];
            canStep = tile.equals(Tile.EMPTY) || tile.equals(Tile.START) || tile.equals(Tile.FINISH);
        }
        return canStep;
    }

    public boolean isWithin(Point point) {
        return point.x >= 0 && point.y >= 0 && point.x < tiles.length && point.y < tiles[point.x].length;
    }
}
