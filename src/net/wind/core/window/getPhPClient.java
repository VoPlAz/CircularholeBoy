package net.wind.core.window;

import net.wind.BoyLoader;
import net.wind.core.Listening.ListenMain;
import net.wind.utils.HttpUtils;

import javax.swing.*;

/**
 * createTime 2022/12/4 0004
 * fileName getPhPClient
 *
 * @author WindStream
 */

public class getPhPClient {
    public static String getPhpClient(){
        String address = JOptionPane.showInputDialog(null,"Input Your CircularHoleBoy php web client address","Infomation",JOptionPane.INFORMATION_MESSAGE);
        return address;
    }
    public static void makesurePhpClient(){
        JOptionPane.showMessageDialog(null,"Your Php Client Address was : " + BoyLoader.phpClient + "/phpClient.php\nMake Sure it if had nothing wrong!");
        HttpUtils.doGet(BoyLoader.phpClient+"/phpClient.php");
    }
}
