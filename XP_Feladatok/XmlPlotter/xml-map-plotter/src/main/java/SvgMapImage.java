import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SvgMapImage implements MapImage {

    SVGGraphics2D svgGenerator;

       
    public Map<String,Color> colors;
    
    public SvgMapImage(int canvasWidth, int canvasHeight) {
        // Get a DOMImplementation.
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        // Create an instance of org.w3c.dom.Document.
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        // Create an instance of the SVG Generator.
        svgGenerator = new SVGGraphics2D(document);
        svgGenerator.setSVGCanvasSize(new Dimension(canvasWidth, canvasHeight));
        colors = new HashMap<>();
        }
   
    @Override
    public void addPoint(double x, double y) {
        svgGenerator.fillOval((int) x, (int) y, 2, 2);
    }

    @Override
    public void save(Writer targetStream) {
        try {
            svgGenerator.stream(targetStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write image", e);
        }
    }
    
    @Override
    public void addPoint(double x, double y, String state) {
    	if (!colors.containsKey(state)) {
    		
    		Color c =new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
    		while (colors.containsValue(c))
    			c =new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
    		colors.put(state, c);
    		
    	}
    	
    	
    	Color c =colors.get(state);
    	svgGenerator.setColor(c);
    	addPoint(x, y);
    }
}
