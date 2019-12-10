package util;

import java.io.*;

/**
 * 关闭占用端口的程序
 */
public class KillUsedPortProcess {

    static String usedPort = "8081";
    static String findPort = "netstat -aon|findstr " + usedPort;
    static String killPre = "taskkill /pid ";
    static String killSuf = " -t -f";

    private static void run() {
        InputStreamReader reader = null;
        try {
            ProcessBuilder builder1 = new ProcessBuilder("cmd", "/c", findPort);
            Process process1 = builder1.start();
            reader = new InputStreamReader(process1.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            String message = bf.readLine();
            if (message != null) {
                String[] messages = message.split(" ");
                String port = messages[messages.length - 1];
                String killCommand = killPre + port + killSuf;
                ProcessBuilder builder2 = new ProcessBuilder("cmd", "/c", killCommand);
                Process process2 = builder2.start();
                reader = new InputStreamReader(process2.getInputStream(), "GBK");
                BufferedReader bf2 = new BufferedReader(reader);
                String msg = "";
                StringBuilder sb = new StringBuilder();
                while ((msg = bf2.readLine()) != null) {
                    sb.append(msg).append("\n");
                }
                System.out.println(sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        run();
    }
}
