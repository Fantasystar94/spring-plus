# SPRING PLUS

#AWS

## EC2 설정
<img width="1273" height="508" alt="image" src="https://github.com/user-attachments/assets/03ed63e1-599a-414f-a9dc-a7b803618555" />

<img width="759" height="444" alt="image" src="https://github.com/user-attachments/assets/d8ae9ffb-2b01-43d6-ad28-df7341d0e88c" />
<img width="769" height="290" alt="image" src="https://github.com/user-attachments/assets/5093fcf0-2831-4d2f-9355-1c5d2dc670bb" />
<img width="763" height="425" alt="image" src="https://github.com/user-attachments/assets/0a79873c-50b3-49ec-b714-e1b915c55ab6" />
<img width="764" height="261" alt="image" src="https://github.com/user-attachments/assets/6434c021-b89d-41bd-9fe0-6c2d890e0442" />
 <img width="621" height="392" alt="image" src="https://github.com/user-attachments/assets/07c4f877-5cb2-4275-9093-762bc73c4af8" />
<img width="1642" height="288" alt="image" src="https://github.com/user-attachments/assets/2a15a260-94c6-4f29-b650-e34c96ee6ab6" />

## RDS 설정
<img width="1590" height="349" alt="image" src="https://github.com/user-attachments/assets/10207e42-c00c-4ef3-983e-365ca49eaa25" />
<img width="1287" height="526" alt="image" src="https://github.com/user-attachments/assets/a1376c71-ba33-4203-9d1b-76fdae086cb3" />

### 설정내용
- EC2 인스턴스에 Ubuntu를 사용하여 서버를 구성하였습니다.
- 보안 그룹에서 8080(Spring), 3306(MySQL) 포트를 허용하였습니다.
- RDS(MySQL)를 퍼블릭 액세스로 생성하고,
  EC2 보안 그룹에서 RDS 3306 포트 접근을 허용하여 연동하였습니다.
- 애플리케이션은 EC2에서 실행되며 RDS와 정상적으로 통신합니다.
