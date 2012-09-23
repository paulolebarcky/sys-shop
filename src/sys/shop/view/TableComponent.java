package sys.shop.view;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paulo
 */
public class TableComponent {

    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();

    public TableComponent() {
    }

    public JTable getTabela(List<Object[]> listObjects) {

        for (Object[] objects : listObjects) {
            model.addRow(objects);
        }
        return table;
    }

    private void addRow(Object[] objects) {
        model.addRow(objects);
    }

    private void removeRow(int indice) {
        model.removeRow(indice);
    }
}
