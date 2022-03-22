Todo:
    503,  84,  85, 221,
-------------------------------------------------------------------------------------------------------------------
 84. Largest Rectangle in Histogram

[find the next smallest element to the left]

Intuition:
There are n rectangles at most. Each rectangle has a height of one of the bars on the histogram.
The question really then is to find the right and left edges, knowing the height.
 Can this all be done in a single pass ?.May be.
 We might need a datastructure to store previously visited bars and re-use them later.

What if we had only bars with increasing heights?
The solution is super easy in this case. Use the height of each of the tall bar as the height of the rectangle,
Their index is the left edge and the right most bar, the right edge. We get the width from this.  We now calculate the area of all such bars
and find the max.

What if the heights are mixed / non increasing ?
May be we can attempt to decompose the histogram in to one that has an increasing order of bars, while also cal

Observation: Every time we pass from one / several tall bars in an increasing order to a shorter one, the tallest bar represents the right most edge
of multiple rectangles, each formed by a corresponding smaller bar to the left - with each of the smaller bars as the left edge and the height
of the corresponding rectangles they form we can easily  compute the areas of all such rectangles.
The short bar to the right doesn't really matter when calculating the area formed the taller bars to the left and is the trigger point to do some area computation.
So we can see that we need a datastructure to store the height of these tall bars to calculate the area formed by each of these tall bars.
But wait, would it be better if we stored the index positions instead ?
Certainly ! why, you ask ? Because the index can give us both the height (height[i])  and the width.
Lets start scanning from left to right, and as long as the bars are in an increasing sequence, add their indices to a datastructure.
So what datastructure do we use to store the indices ?
     Lets say we use a LIST for now, to store the indices of the tall bars. The index of the tallest bar is at the last position of this LIST
     If we see a short bar that breaks the increasing sequence, we stop.
     We start computing the area formed by the tall bars one at a time (we use its height).
    Each of the tall bars (to the left of the short bar) is also the left edge.
    The tallest bar is the right edge. But the shorter bar 1 index to the right, can be used as a marker for this right edge (short bar - 1)
    In other words, the short bar that breaks the increasing sequence marks the right edge.
    Now we have the left edge (index of the tall bar), the right edge (short bar - 1) and the height
                                                            (  height of the tall bar which is at the last position of our LIST)
    Once we use the tallest bar to calculate the area of the first rectangle, we can discard it(pop) as we can always use
    the index of the current bar (short bar) as a marker to calculate the width.
    we can see that STACK is a better choice as we first calculate the area formed by the tallest bar first(Last in, first out)
    and we really dont need it after that (POP).
And when do we stop all this popping off the stack?
  Until there are no more tall bars in the stack that are taller than our short bar of interest.
What do we do with the short bar after that ?
  we could put the short bar in to the stack (this short bar will be tallest in the stack now),
  to continue with our increasing sequence of bars in the stack.
  What if the next bar that follows this short bar in the stack is even shorter ?
    We need to calculate the area of the rectangle formed by the bar in the stack.
    its left edge extends all the way to the start of the histogram and the index of the short bar doesn't reflect that.
    we could always initialize the stack to an index of -1  to mark the begining of the histogram
What next ?
 We repeat the above algorithm, adding taller bars in to the stack, but as soon as we see as short one, start popping / calculating areas.


So do we store the indices of all the bars we encounter in the stack or just some specific ones ?
    We already determined that we  are only interested in keeping track of the indices of the bars that have an increasing sequence of heights.
    So the stack we use will be a strictly monotonic stack.

What do we do after scanning all bars from left to right and there are still some bars left on the stack?
 we have seen this movie before!
  we pop one at a time and calculate the area formed by each of the bars. [current = stack.pop ] But how?
        we know their height.
        we know the index of the right end of the rectangle. But do we ?
           well by this point, the right end of the rectangle will always be index of the last bar in the histogram / length of the histogram.
        we know the index of the left end of the rectangle which can be calculated using
           a) the index of the current bar or b) the index of the bar before  the current one,  at the top of the stack
           can we use the index of the current bar to represent the left end ?
              Lets assume we can.
           What happens after we get to the last bar in the stac ?  (which is also the shortest).
           Is the index of this bar representative of left end of the rectangle formed using its height?
                actually not! the left end is pretty much the start of the histogram and not the current index.
           Again, can we use the index of the current bar to represent the left end ?
                 we can't. we need a more general way of marking the left edge of the rectangle.
           can we use the index of the previous bar at the top of the stack[ stack.peek() ]  instead of the current bar that we just popped?
                May be, but for the last(shortest) bar, there is no previous bar in the stack.Wait, there is!
                   we have inittialized the stack with a marker index of -1 to mark the left end of the rectangle formed
                   by the shortest bar (the begining of the histogram)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 Next greatest element:
 [find the next greatest element to the right:  scan from right to left]




