package leetcode;
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS solution is by counting the course of the edges of out and in to be the same is the same with course number.
        //DFS with topological sorting Kahn method
        ArrayList<Integer>[] graph=(ArrayList<Integer>[])new ArrayList[numCourses];
        //we could also use a map here
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] recStack=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
        		if(dfs(visited,recStack,graph,i)==true){
        			return false;
        		}
        }
        return true;
    }
	public boolean dfs(boolean[] visited, boolean[] recStack,ArrayList<Integer>[] graph, int i){
		if(visited[i]==false){
			visited[i]=true;
			recStack[i]=true;
			for(int arr:graph[i]){
				if(visited[arr]==false && dfs(visited,recStack,graph,arr)==true){
				    //首先要利用DFS，遍历，如果之后的有环，那么就有环，前提是没被访问过，如果访问了，就重复了
					return true;
				}
				else if(recStack[arr]) return true;
				//如果这条路径曾经走过。那么有环。  无向图就不存在这种问题，不需要做回溯。
				
				//也可以用这个判断句
				//if(recStack[arr]==true || dfs(visited,recStack,graph,arr)==true){
				//	return true;
				//}
			}
			recStack[i]=false;
		}
		return false;
	}
	
	
	//BFS
	public class Solution {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        ArrayList[] graph = new ArrayList[numCourses];
	        int[] degree = new int[numCourses];
	        Queue queue = new LinkedList();
	        int count=0;

	        for(int i=0;i<numCourses;i++)
	            graph[i] = new ArrayList();

	        for(int i=0; i<prerequisites.length;i++){
	            degree[prerequisites[i][1]]++;
	            graph[prerequisites[i][0]].add(prerequisites[i][1]);
	        }
	        for(int i=0; i<degree.length;i++){
	            if(degree[i] == 0){
	                queue.add(i);
	                count++;
	            }
	        }

	        while(queue.size() != 0){
	            int course = (int)queue.poll();
	            for(int i=0; i<graph[course].size();i++){
	                int pointer = (int)graph[course].get(i);
	                degree[pointer]--;
	                if(degree[pointer] == 0){
	                    queue.add(pointer);
	                    count++;
	                }
	            }
	        }
	        if(count == numCourses)
	            return true;
	        else    
	            return false;
	    }
	}
}
