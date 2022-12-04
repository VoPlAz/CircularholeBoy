package net.wind.core.window;

/**
 * createTime 2022/12/3 0003
 * fileName getReFreshtime
 *
 * @author WindStream
 */
import javax.swing.JOptionPane;

public class getReFreshtime {
    public static int getRefreshtime(){
        String time = JOptionPane.showInputDialog(null,"Refresh Time[ms]","Press Refresh time",JOptionPane.INFORMATION_MESSAGE);
        if(time==null){
            JOptionPane.showMessageDialog(null,"If you do not input the refresh time ,it's will be 1000ms","Information",JOptionPane.INFORMATION_MESSAGE);
            return 1000;
        }else {
            int 时间 = Integer.parseInt(time);
            return 时间;
        }
    }
}
