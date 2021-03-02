public class PathNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Path cannot be found";
    }
}
