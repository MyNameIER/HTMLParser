import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("C:\\Users\\Иван\\IdeaProjects\\HTMLParsing\\data\\file.txt");
        String htmlFile = parseFile("C:\\Users\\Иван\\IdeaProjects\\HTMLParsing\\data\\code.html");
        Document doc = Jsoup.parse(htmlFile);

        Elements links = doc.select("img");
        links.forEach(link -> {
            writer.write(link.attr("abs:src") + "\n");
            System.out.println(link.attr("abs:src"));
        });
        writer.flush();
        writer.close();
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
