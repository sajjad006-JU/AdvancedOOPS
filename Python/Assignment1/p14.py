# 14.  Implement  a  priority  queue  that  sorts  items  by  a  given  priority  and  always 
# returns the item with the highest priority on each pop operation.

import heapq

class PriorityQueue:
    def __init__(self):
        self.queue = []

    def push(self, item, priority):
        heapq.heappush(self.queue, (-priority, item))

    def pop(self):
        return heapq.heappop(self.queue)[1]
    
pq = PriorityQueue()
pq.push("Task 1", priority=2)
pq.push("Task 2", priority=1)
pq.push("Task 3", priority=3)
print(pq.pop())  # Should return "Task 3"
print(pq.pop())  # Should return "Task 1"