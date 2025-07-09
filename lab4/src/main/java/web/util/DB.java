package web.util;
import java.util.HashMap;
import java.util.Map;
import web.model.Item;

public class DB {
	public static Map<Integer, Item> items = new HashMap<>();
	static {
	    items.put(1, new Item(1, "samsung", 10.0, 0));
	    items.put(2, new Item(2, "iphone", 10.0, 0));
	    items.put(3, new Item(3, "nokia", 10.0, 0));
	    items.put(4, new Item(4, "vsmart", 10.0, 0));
	}
}
