package aJan22.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//1656
/*
    just use arrays instead.
 */
public class OrderedStream {

    int ptr = 1;
    TreeMap<Integer, String> stream = new TreeMap<>();

    public OrderedStream(int n) {

    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        stream.put(idKey, value);
        while(stream.containsKey(ptr)) ans.add(stream.remove(ptr++));
        return ans;
    }
}
