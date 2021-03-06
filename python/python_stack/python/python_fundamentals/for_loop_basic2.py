# 1Biggie Size - Given a list, write a function that changes all positive numbers in the list to "big".
    #Example: biggie_size([-1, 3, 5, -5]) returns that same list, but whose values are now [-1, "big", "big", -5]
def biggie(arr):
    for i in range(0, len(arr), 1):
        if(arr[i]>0):
            arr[i] = 'big'
        return arr
print(biggie([1, -4, 0, 6, -3]))

#2 Count Positives - Given a list of numbers, create a function to replace the last value with the number of positive values. (Note that zero is not considered to be a positive number).
    #Example: count_positives([-1,1,1,1]) changes the original list to [-1,1,1,3] and returns it
    #Example: count_positives([1,6,-4,-2,-7,-2]) changes the list to [1,6,-4,-2,-7,2] and returns it
def count(arr):
    count=0
    for i in range(0, len(arr), 1):
        if(arr[i]>0):
            count+=1
    arr[len(arr)-1]= count
    return arr
print(count([-1, 4, 0, 6, -8]))
#3 Sum Total - Create a function that takes a list and returns the sum of all the values in the array.
    #Example: sum_total([1,2,3,4]) should return 10
    #Example: sum_total([6,3,-2]) should return 7
def sum (arr):
    sum=0
    for i in range(0, len(arr), 1):
        sum+=arr[i]
    return sum
print(sum([1, 2, 3, 4, 5,]))
#4 Average - Create a function that takes a list and returns the average of all the values.
    #Example: average([1,2,3,4]) should return 2.5
def average (arr):
    sum = 0
    for i in range(0, len(arr), 1):
        sum+=arr[i]
    return (sum/len(arr))
print(average([1, 2, 3, 4, 5]))
#5 Length - Create a function that takes a list and returns the length of the list.
    #Example: length([37,2,1,-9]) should return 4
    #Example: length([]) should return 0
def length (arr):
    return len(arr)
print(length([1, 2, 3, 4, 5]))
#6 Minimum - Create a function that takes a list of numbers and returns the minimum value in the list. If the list is empty, have the function return False.
    #Example: minimum([37,2,1,-9]) should return -9
    #Example: minimum([]) should return False
def minimum(arr):
    min=arr[0]
    if len(arr)==0:
        return False
    else:
        for i in range(1, len(arr), 1):
            if(arr[i]<min):
                min=arr[i]
    return min
print(minimum([4, -3, 0 , 7, -6]))

#OR def minimum(arr):
        #return min(arr)
    #print(minimum([4, -3, 0 , 7, -6])) 

#7 Maximum - Create a function that takes a list and returns the maximum value in the array. If the list is empty, have the function return False.
    #Example: maximum([37,2,1,-9]) should return 37
    #Example: maximum([]) should return False
def maximum(arr):
    max=arr[0]
    if len(arr)==0:
        return False
    else:
        for i in range(1, len(arr), 1):
            if(arr[i]<max):
                max=arr[i]
    return max
print(minimum([4, -3, 0 , 7, -6]))

#OR def maximum(arr):
        #return max(arr)
    #print(maximum([4, -3, 0 , 7, -6])) 
#8 Ultimate Analysis - Create a function that takes a list and returns a dictionary that has the sumTotal, average, minimum, maximum and length of the list.
    #Example: ultimate_analysis([37,2,1,-9]) should return {'sumTotal': 31, 'average': 7.75, 'minimum': -9, 'maximum': 37, 'length': 4 }
import statistics
def ultAnalysis(arr):
    return "sumTotal:", sum(arr), "max:", max(arr), "min:", min(arr),"avg:", statistics.mean(arr)

print(ultAnalysis([37,2,1,-9]))

#9 Reverse List - Create a function that takes a list and return that list with values reversed. Do this without creating a second list. (This challenge is known to appear during basic technical interviews.)
    #Example: reverse_list([37,2,1,-9]) should return [-9,1,2,37]
def revList(arr):
    for i in range(int(len(arr)/2)):
        temp = arr[i]
        arr[i] = arr[len(arr)-(i+1)]
        arr[len(arr)-(i+1)] = temp
    return arr
print(revList([1,2,3,4,5]))