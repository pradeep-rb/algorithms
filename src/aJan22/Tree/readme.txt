366. Find Leaves of Binary Tree (and order then by 'leaf order')

input:
    1
  2   3
4   5

output :  [[4,5,3],[2],[1]]

soln:

 1) traverse in this order   left, right, root
 2) at root calculate height as   rootH =  1 + max (left height + right height)
 3) when you see a new height  (when ans.length == rooH ), create a new entry in the ans arraylist
 this way answer is sorted by leaf order
 ----------------------------------------------------------------------------------------------------------------------------------