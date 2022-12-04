package net.wind.core.window;

import net.wind.BoyLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.wind.utils.shell.ShellCommand;
/**
 * createTime 2022/12/3 0003
 * fileName ShellWindow
 *
 * @author WindStream
 */


public class ShellWindow extends JFrame implements Runnable{
    public static JTextArea WindowMainArea = new JTextArea();
    private JTextField WindowSendingArea = new JTextField();
    public static String Session_Status = "No Session";

    public ShellWindow(){}
        @Override
        public void run() {
            setTitle("Shell Window || By WindStream");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            WindowMainArea.setEditable(false);
            WindowMainArea.setBackground(Color.BLACK);
            WindowMainArea.setForeground(Color.GREEN);
            Container c = getContentPane();
            JScrollPane jScrollPane = new JScrollPane(WindowMainArea);
            getContentPane().add(jScrollPane, BorderLayout.CENTER);
            c.add(WindowSendingArea, "South");
            //Append Info of program
            WindowMainArea.append(BoyLoader.SoftWareName + "  "+BoyLoader.ProgramVersion + "\n");
            WindowMainArea.append("By "+BoyLoader.Author+"\n");
            WindowMainArea.append("Use command \"shell_help\" to know how to use it...\n\n");


            WindowSendingArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    WindowMainArea.append("CircularHoleBoy("+Session_Status+") ---> " + WindowSendingArea.getText() + "\n");
                    WindowMainArea.append(ShellCommand.command(WindowSendingArea.getText()));
                    WindowSendingArea.setText("");
                }
            });
            setSize(600,600);
            setVisible(true);
        }


    public static void buildShellWindow(){
        Thread buildShellWindow =new Thread(new ShellWindow());
        buildShellWindow.setDaemon(true);
        buildShellWindow.setName("ShellWindow");
        buildShellWindow.setPriority(5);
        buildShellWindow.start();
    }
}
