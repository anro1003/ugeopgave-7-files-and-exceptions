import java.util.ArrayList;

public class Opgave2b {
    public static String getItem(ArrayList<String> items, int index) {
        if(items.size() == 0)
        {
            throw new IllegalArgumentException("ArrayList is empty - No index is valid");
        }
        if(index >= items.size() || index < 0)
        {
            throw new IllegalArgumentException("Invalid Index: " + index + " - Valid range is: 0 - " + (items.size()-1));
        }
        return items.get(index);
    }
}
