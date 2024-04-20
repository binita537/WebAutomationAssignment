package com.webautomation.data;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class ProductWorld {
    private Map<String, Object> productMap;

    public ProductWorld() {
        productMap = new HashMap<>();
    }
    
    public void put(String key, Object value) {
    	productMap.put(key,  value);
    }
    
    public Object get(String key) {
        return productMap.get(key);
    }
}
