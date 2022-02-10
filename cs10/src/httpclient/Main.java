package httpclient;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");

        InetAddressTest inetAddressTest = new InetAddressTest(url);
        inetAddressTest.getHostAddress();
        String hostAddress = inetAddressTest.getAddress();

        Socket socket = new Socket(hostAddress, 80);
        System.out.println("80번 Port 연결 완료 !");
        System.out.println("TCP Connection : " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());

        // 서버로 Request 보낼 때 Writer 에 적어서 flush() 를 통해 요청을 보냄 (Header 같은 거)
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // 서버에서 Request 받아야 함
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        sendMessage(output);
        readResponse(input);

        String inputLine;

        while ((inputLine = input.readLine()) != null) {
            System.out.println(inputLine);
        }

        input.close();
        output.close();
    }

    private static void sendMessage(BufferedWriter output) throws IOException {
        System.out.println(" 서버에 Request를 보냅니다.");

        List<String> lines = new ArrayList<>();
        lines.add("GET /?clienmt=safari");
        lines.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15");
        lines.add("ko-kr");
        lines.add("gzip, deflate, br");
        lines.add("keep-alive");

        // 서버로 보낼 여러가지 Request Head 정보들을 출력
        for (String line : lines) {
            System.out.println(line);
            output.write(line + "\r\n");
        }

        // Request Header 와 Request Body 는 한 칸 띄워져 있어야 하므로 개행 필요
        output.write("\r\n");

        // flush()를 통해 Buffer 를 비우면서 한 번에 서버로 전송
        output.flush();
    }

    private static void readResponse(BufferedReader input) throws IOException {
        System.out.println("\n * Response");
        String line;

        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
    }
}
