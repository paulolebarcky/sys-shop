package sys.shop.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sys.shop.util.Message;

/**
 *
 * @author paulo
 */
public class DefaultView extends JPanel {

    public static String BTN_INCLUIR = "Incluir";
    public static String BTN_EDITAR = "Editar";
    public static String BTN_EXCLUIR = "Excluir";
    public static String BTN_LOCALIZAR = "Localizar";
    public static String BTN_GRAVAR = "Gravar";
    public static String BTN_CANCELAR = "Cancelar";
    public static String FCN_BTN_ATUALIZAR = "atualizar";
    public static String FCN_BTN_ADICIONAR = "adicionar";

    /**
     * Caixa de dialogo que representa uma questão a ser respondida
     * (Sim ou Não)
     *
     * @param question
     * @return boolean
     */
    protected boolean hasSure(String question) {
        int n = JOptionPane.showConfirmDialog(null,
                question, Message.MSG_ATENCAO,
                JOptionPane.YES_NO_OPTION);
        return n == 0 ? false : true;
    }
}
