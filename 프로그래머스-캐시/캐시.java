import java.util.*;

class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0; int cacheCount = 0; int idx = 0;
            LinkedList<String> cache = new LinkedList<>();

            if(cacheSize == 0)
                return 5 * cities.length;

            for(int i=0; i<cities.length; i++){

                if(cache.contains(cities[i].toUpperCase())){ // cache hit
                    answer += 1;
                    idx = cache.indexOf(cities[i].toUpperCase()); // hit한 cache의 index 반환

                    cache.remove(idx);
                    cache.add(cities[i].toUpperCase());




                } else { // cache miss

                    answer += 5;

                    if(cacheSize == cacheCount){ // cache 꽉 참
                        cache.remove(0);
                        cache.add(cities[i].toUpperCase());

                    } else { // cache 비어 있음
                        cache.add(cities[i].toUpperCase());
                        cacheCount++;
                    }


                }

            }

            return answer;
        }
    }