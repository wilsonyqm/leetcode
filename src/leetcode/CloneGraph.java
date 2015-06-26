package leetcode;
//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

import java.util.*;
public class CloneGraph {
	Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
        map.put(node,new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode newnode=queue.remove();
			UndirectedGraphNode clonenode=map.get(newnode);
			for(UndirectedGraphNode neighbor:newnode.neighbors){
				if(!map.containsKey(neighbor)){
					//只有当没有被遍历的时候，才用得着建立一个新的Node
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				clonenode.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}
}
