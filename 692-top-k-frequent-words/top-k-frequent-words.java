class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>
        (
            (a,b)-> {
                    if(!map.get(a).equals(map.get(b)))
                        return map.get(a)-map.get(b);
                    return b.compareTo(a);
            }

        );
        for(String key:map.keySet())
        {
            pq.offer(key);
            if(pq.size()>k) pq.poll();
        }
        List<String> ans=new ArrayList<>();
        int i=0;
        while(!pq.isEmpty())
        {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}