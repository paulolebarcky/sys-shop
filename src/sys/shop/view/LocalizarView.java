package sys.shop.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sys.shop.controller.LojaController;
import sys.shop.entity.Loja;

/**
 *
 * @author paulo
 */
public class LocalizarView extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable();
    private Map<Integer, Object> map;
    

    /**
     * Creates new form LocalizarView
     */
    public LocalizarView() {
        createTable();
        initComponents();
        jScrollPane1.setViewportView(table);
    }

    private void createTable() {
        table = new JTable(model);
        model.addColumn("Código");
        model.addColumn("Loja");

        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        
        LojaController lojaController = new LojaController(new Loja());
        List<Loja> listLoja = lojaController.findEntities();
        
        if (map == null) {
            map = new HashMap<Integer, Object>();
        }

        for (Loja loja : listLoja) {
            model.addRow(new Object[]{loja.getLojId().toString(), loja.getLojNome()});
            map.put(loja.getLojId(), loja);
        }

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (e.getValueIsAdjusting()) {
                    int codLoja =  Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
                    Loja loja = (Loja) map.get(codLoja);
                    LojaView.setLoja(loja);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigoLocalizar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Localizar");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Código:");

        txtCodigoLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoLocalizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigoLocalizar;
    // End of variables declaration//GEN-END:variables
}
