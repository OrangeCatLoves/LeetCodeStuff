# Find the largest element in the array (Locate the index)
# Invert the element to the start of the array
# And then invert the unsorted portion of the array to
# Push the largest element to the correct position

class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        result = list()
        size = len(arr)
        for i in range(size, 0, -1):
            currIndexOfLargest = arr.index(max(arr[0 : i]))
            if (currIndexOfLargest == i - 1):
                continue
            result.append(currIndexOfLargest + 1)
            arr[0 : currIndexOfLargest + 1] = arr[0 : currIndexOfLargest + 1][::-1]
            result.append(i)
            # Reverse the subarray 
            arr[0 : i] = arr[0 : i][::-1]
        
        return result
        
