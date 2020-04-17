import collections

def solution(priorities, location):
    
    answer = 0
    de_prior = collections.deque(priorities)
    while True:
        if location == 0:
            
            if de_prior[0] < max(de_prior):
                temp = de_prior[0]
                de_prior.popleft()
                de_prior.append(temp)
                location = len(de_prior) - 1
            else:
                answer += 1
                return answer
            
        else:
            if de_prior[0] < max(de_prior):
                temp = de_prior[0]
                de_prior.popleft()
                de_prior.append(temp)
                location -= 1
            
            else:
                de_prior.popleft()
                location -= 1
                answer += 1
                
    return answer