import java.util.HashMap;
import java.util.Map;

public class Parser {
    private final static Map<Character, Tile> _tiles = new HashMap<>();
    static {
        _tiles.put('#', Tile.WALL);
        _tiles.put('.', Tile.EMPTY);
        _tiles.put('s', Tile.START);
        _tiles.put('f', Tile.FINISH);
    }

    public static Tile[][] parse(String[] lines) {
        Tile[][] map = new Tile[lines.length][lines[0].length()];
        for(int i = 0; i < lines.length; i++) {
            char[] chrArr = lines[i].toCharArray();
            for(int j = 0; j < chrArr.length; j++) {
                map[i][j] = _tiles.get(chrArr[j]);
            }
        }
        return map;
    }
}
