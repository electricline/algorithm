import time

start_time = time.time() # 측정시작

N = int(input())
dir = input().split()
s_r = 1
s_c = 1

dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]
move = ['L', 'R', 'U', 'D']

for i in dir:

    for j in range(len(move)):
        if i == move[j]:
            nr = s_r + dy[j]
            nc = s_c + dx[j]

    if nr < 1 or nr > N or nc < 1 or nc > N:
        continue

    s_r, s_c = nr, nc

print(s_r, s_c)

end_time = time.time() # 측정 종료
print("time :", end_time - start_time)