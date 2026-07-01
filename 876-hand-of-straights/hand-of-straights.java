class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num : hand) 
        {
            if(map.containsKey(num)) 
            { 
                map.put(num, map.get(num) + 1); 
            }
            else 
            {
                map.put(num, 1); 
            }
        }
        while(!map.isEmpty())
        {int first = map.firstKey(); // Step 6 
        for(int i = 0; i < groupSize; i++)
         {
             int current = first + i; // Step 7
              if(!map.containsKey(current)) 
              {
                 return false;
             } // Step 8 
             map.put(current, map.get(current) - 1); // Step 9
              if(map.get(current) == 0) 
              { map.remove(current); }
        }
        }
        return true;
    }
}