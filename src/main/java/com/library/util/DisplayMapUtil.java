package com.library.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;

public class DisplayMapUtil<T> {

    public boolean canBeSelected(Map<Integer, T> map, String selector) {
        return isParsable(selector) && map.containsKey(Integer.parseInt(selector));
    }

    public Map<Integer, T> displayMap(List<T> list) {
        Map<Integer, T> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i + 1, list.get(i));
        }
        return map;
    }
}
