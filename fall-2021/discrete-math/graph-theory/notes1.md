### Graph Theory 
- A graph G = (V, E) is pair of *vertices(nodes* V and a set of *edges* E. 
    * |V| = n
    * |E| = m

- An edge e<sub>k</sub> = (v<sub>k</sub>, v<sub>k</sub>) is **incident** with
v<sub>k</sub> and v<sub>k</sub>.

- Simple graphs has no self loops.

### Some properties
- The *degree* d(v) of a vertex V is its number of incident edges.
- Self-loop has degree 1, isolated vertex has degree 0.
- The sum of the degrees of a graph G = (V, E) equals 2|E| = 2m

- Number of odd degree is even 

- **Complete** graph is a graph that use all possible edges.

- **k-regular** graph is a simple graph with vertices are equal degree *k*.

- Complete graph K<sub>n</sub> is (n - 1)-regular.

- **Bipartite** graph's edge can seperate vertices into two set.  

**NOTE:** Odd numbers of vertices loop brokes bipartite. 

* Complete Bipartite graph is one where all edges between V1 and V2 are present(K<sub>n1,n2</sub>).
    
### Walking in a graph 
-**walk:** kinda traversing through graph without any restriction.  
-**trial:** a walk with all different *edges*.
-**path:** a walk with all different nodes(and hence edges).
- A walk or trial is *closed* when v0 = vk.
- *cycle* is close walk witout reapeating edge

- **Directed graphs**: each edge has a direction.
    * e = (v<sub>source</sub>, v<sub>terminal</sub>)

- in-degree is #in direct edge
- out-degree is #out direct edge
- graph is *balanced* if din(V) = dout(V)
