package sys.shop.util;

import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class Message {
    
    public static String MSG_SUCESSO = "Sucesso";
    public static String MSG_FALHA = "Falha";

    /**
     *
     * @param msg
     */
    public static void show(String msg, String title, int tipoMsg) {
        JOptionPane.showMessageDialog(null, msg,title, tipoMsg);
    }
}
