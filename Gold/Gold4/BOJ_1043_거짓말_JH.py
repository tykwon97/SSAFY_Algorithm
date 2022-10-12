# “나에게 거짓말을 들은 사람들이 다른 파티에서 진실을 알고있는 사람과 만날 경우” 를 고려해야함

N, M = map(int, input().split())
true_arr = set(map(int, input().split()[1:]))  # 진실을 아는 사람 -> 집합연산 위해 set으로 만들어줌

parties = []  # 각 파티마다 오는 사람 번호 저장
for _ in range(M):  # 파티수만큼 오는 사람 번호 입력받기
    parties.append(set(map(int, input().split()[1:])))

party = [True] * M  # 거짓말해도 된다고 설정하고 시작

for i in range(M):  # 파티의 수만큼 돌려줘야함***********************
    for j in range(len(parties)):
        if true_arr & parties[j]:  # 교집합이 있다면(진실을 아는 사람이 한명이라도 있으면)
            true_arr = true_arr | parties[j]  # 합집합으로 합쳐줌(거기 있는 모든 사람들을 진실을 아는 사람들로 간주)
            party[j] = False  # 거짓말하면안됨

print(party.count(True))

