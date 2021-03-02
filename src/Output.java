import java.util.HashMap;
import java.util.Map;

public class Output {
    private static final Map<Tile, Character> _chars = new HashMap<>();
    static {
        _chars.put(Tile.FINISH, 'f');
        _chars.put(Tile.START, 's');
        _chars.put(Tile.EMPTY, '.');
        _chars.put(Tile.WALL, '#');
        _chars.put(Tile.PATH, '*');
    }

    public static String[] Prepare(Tile[][] tiles) {
        String[] result = new String[tiles.length];
        for(int i = 0; i < result.length; i ++) {
            char[] chrArr = new char[tiles[i].length];
            for(int j = 0; j < chrArr.length; j++) {
                chrArr[j] = _chars.get(tiles[i][j]);
            }
            result[i] = new String(chrArr);
        }
        return result;
    }
}
