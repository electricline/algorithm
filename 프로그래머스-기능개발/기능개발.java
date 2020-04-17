import math

def solution(progresses, speeds):
    answer = []
    result = []

    num = len(progresses)
    
    # 0 ~ num-1
    for i in range(num):
        temp = 100 - progresses[i] 
        temp = temp / speeds[i]
        temp = math.ceil(temp)
        result.append(temp)
    
    n = 1
    
    # °°Àº number·Î 
    for i in range(1, len(result)):
        if result[i-1] > result[i]:
            result[i] = result[i-1]
    
    
    
    for i in range(1, len(result)):
        if result[i-1] >= result[i]:
            n += 1
        else:
            answer.append(n)
            n = 1
            
    answer.append(n)
            
            
    
    return answer