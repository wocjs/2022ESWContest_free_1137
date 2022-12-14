import base64

import cv2
import socket
import argparse
import threading
import time
import numpy as np
import pymysql

host = "192.168.0.84"
port = 4000

DBAddr = "192.168.0.83"
DBPort = 3306

HostAddr = "192.168.0.84"
HostPort = 4000

def handle_client(client_socket, addr):
    print("접속한 클라이언트의 주소 입니다. : ", addr)
    user = client_socket.recv(1024)
    print(f"{user}")
    client_socket.sendall(StrMap.encode('utf-8'))
    print(StrMap)
    print("1초 후 클라이언트가 종료됩니다.")
    time.sleep(1)
    client_socket.close()

def accept_func():
    global server_socket
    #IPv4 체계, TCP 타입 소켓 객체를 생성
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    #포트를 사용 중 일때 에러를 해결하기 위한 구문
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    #ip주소와 port번호를 함께 socket에 바인드 한다.
    #포트의 범위는 1-65535 사이의 숫자를 사용할 수 있다.
    server_socket.bind((host, port))

    #서버가 최대 5개의 클라이언트의 접속을 허용한다.
    server_socket.listen(5)

    while 1:
        try:
            #클라이언트 함수가 접속하면 새로운 소켓을 반환한다.
            client_socket, addr = server_socket.accept()
        except KeyboardInterrupt:
            server_socket.close()
            print("Keyboard interrupt")

        print("클라이언트 핸들러 스레드로 이동 됩니다.")
        #accept()함수로 입력만 받아주고 이후 알고리즘은 핸들러에게 맡긴다.
        t = threading.Thread(target=handle_client, args=(client_socket, addr))
        t.daemon = True
        t.start()


if __name__ == '__main__':
    #parser와 관련된 메서드 정리된 블로그 : https://docs.python.org/ko/3/library/argparse.html
    #description - 인자 도움말 전에 표시할 텍스트 (기본값: none)
    #help - 인자가 하는 일에 대한 간단한 설명.
    parser = argparse.ArgumentParser(description="\nJoo's server\n-p port\n")
    parser.add_argument('-p', help="port")

    args = parser.parse_args()
    try:
        port = int(args.p)
    except:
        pass
    Map = np.zeros((5, 5), dtype=np.int32)

    conn = pymysql.connect(host=DBAddr, user='temp', password='s950j970**',
                           db='minky', charset='utf8')
    cursor = conn.cursor()
    sql = "select * from map"
    cursor.execute(query=sql)
    conn.commit()
    result = cursor.fetchall()
    conn.close()
    print("DB 서버로 부터 데이터를 받아왔음.")
    for i, v in enumerate(result):
        lat = v[1]
        lon = v[2]
        x = 4 - round((5/0.032) * (lon - 129.068))
        y = 5 - round(-(5 / 0.027) * (lat - 35.093))
        Map[x, y] = int(v[5])

    MatMap = Map.flatten().astype(np.str_)
    StrMap = ",".join(MatMap.tolist())
    print("그리드 생성 완료.")
    accept_func()