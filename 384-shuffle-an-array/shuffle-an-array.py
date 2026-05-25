class Solution(object):
    def __init__(self, nums):
        from copy import deepcopy
        self.original = deepcopy(nums)
        self.current = deepcopy(nums)

    def reset(self):
        self.current = self.original[:]
        return self.current

    def shuffle(self):
        from random import shuffle
        shuffle(self.current)
        return self.current