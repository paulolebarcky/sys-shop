package sys.shop.view;

import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sys.shop.controller.PrincipalController;
import sys.shop.entity.Estado;
import sys.shop.util.Message;

/**
 *
 * @author paulo
 */
public class DefaultView extends JPanel {
    
    public static final Logger logger = Logger.getLogger(PrincipalController.class.getName());

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
    
    /**
     * Recupera o código do item selecionado no combo.
     * @param combo
     * @return 
     */
    protected int getSelectedItemCombo(JComboBox combo) {
        final String selectedItem = (String) combo.getModel().getSelectedItem();
        final int i = selectedItem.indexOf("-");

        if (i < 1) {
            String msg = "Ocorreu um erro para recuperar o índice do item selecionado no combo.";
            Message.show(msg, Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            logger.info(msg);
        }
        return Integer.valueOf(selectedItem.substring(0, i - 1).trim());
    }
    
    /**
     * Recupera o objeto de dentro de um mapa. Utilizado para tratar combo.
     * @param map
     * @param key
     * @return 
     */
    public Object getKeyValueMap(Map<String, Object> map, int key) {
        
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String string = entry.getKey();
            final int i = string.indexOf("-");

            int codEstado = Integer.valueOf(string.substring(0, i - 1).trim());
            if (key == codEstado) {
                return entry.getValue();
            }
        }
        return null;
    }
}
