import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class QueryString {
    private List<String> pairs = new ArrayList<>();

    // Add a name-value pair to the query string
    public void add(String name, String value) {
        try {
            // URLEncoder encodes the name and value to ensure safe HTTP transmission
            String encodedName = URLEncoder.encode(name, "UTF-8");
            String encodedValue = URLEncoder.encode(value, "UTF-8");
            pairs.add(encodedName + "=" + encodedValue);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // Handle potential encoding exceptions
        }
    }

    // Convert the list of name-value pairs to a query string
    @Override
    public String toString() {
        return String.join("&", pairs);
    }
}
