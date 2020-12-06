import java.io.Writer;

public interface MapImage {
    void addPoint(double x, double y);

    void save(Writer targetStream);

	void addPoint(double yCoordinate, double xCoordinate, String state);
}
