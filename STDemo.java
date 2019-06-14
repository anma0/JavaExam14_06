import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class STDemo {
    public static void main(String[] args) {
        StringTransformer st1 = s -> s.replace("F", "F+F--F+F");

        String rect = "<rect x=\"0\" width=\"100\" y=\"0\" height=\"100\" style=\"stroke:#0000ff; fill: #000000\"  />";
        StringTransformer st2 = s -> {
            String newRect =
                    "<g transform=\"scale(0.333333333333 0.3333333333333)\">" + s + "<g transform=\"translate(100,0)\" >" + s + "</g>";
            newRect += "<g transform=\"translate(200,0)\" >" + s + "</g>" +
                    "<g transform=\"translate(0,100)\" >" + s + "</g>" +
                    "<g transform=\"translate(200,100)\" >" + s + "</g>" +
                    "<g transform=\"translate(0,200)\" >" + s + "</g>" +
                    "<g transform=\"translate(100,200)\" >" + s + "</g>" +
                    "<g transform=\"translate(200,200)\" >" + s + "</g></g>";
            return newRect;
        };

        try {
            Files.writeString(Paths.get("out.txt"), st1.transform("F", 3));
            Files.writeString(Paths.get("out2.svg"), "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">" + st2.transform(rect, 2) + "</svg>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
