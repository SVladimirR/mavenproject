package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;



    public class SimpleCache {

        private final Map<String, Map<String, Object>> caches;
        private final Logger logger;


        public SimpleCache() {
            caches = new HashMap<>();
            logger = Logger.getLogger(org.example.SimpleCache.class.getName());
        }


        public boolean put(String cache, String key, Object o) {
            if (!caches.containsKey(cache)) {
                caches.put(cache, new HashMap<>());
            }
            caches.get(cache).put(key, o);
            logger.info("Put '" + key + "' in cache'" + cache + "'");
            return true;
        }


        public Object get(String cache, String key) {
            if (caches.containsKey(cache)) {
                return caches.get(cache).get(key);
            }
            return null;
        }


        public void clear(String cache) {
            if (caches.containsKey(cache)) {
                caches.get(cache).clear();
                logger.info("Cache '" + cache + "' cleared");
            }
        }


        public void clear() {
            caches.clear();
            logger.info("All caches cleared");
        }


        public boolean isCacheExist(String cache) {
            return caches.containsKey(cache);
        }
}
