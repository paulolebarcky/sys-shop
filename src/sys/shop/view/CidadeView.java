package sys.shop.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sys.shop.controller.CidadeController;
import sys.shop.controller.EstadoController;
import sys.shop.controller.exceptions.NonexistentEntityException;
import sys.shop.entity.Cidade;
import sys.shop.entity.Estado;
import sys.shop.util.Message;

/**
 *
 * @author paulo
 */
public class CidadeView extends DefaultView {
    
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
    private Map<String, Object> map;
    
    private JTable table = new JTable();
    private int indiceSelect;
    private List<Estado> listEstado;

    /**
     * Creates new form CidadeView
     */
    public CidadeView() {
        createComboEstado();
        createTable();
        initComponents();
        jScrollPane1.setViewportView(table);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cbxEstado = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Cidades"));

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnIncluir)
                .addComponent(btnEditar)
                .addComponent(btnExcluir)
                .addComponent(btnLocalizar))
        );

        lblCodigo.setText("Código:");

        lblEstado.setText("Estado:");

        lblCidade.setText("Cidade:");

        txtCodigo.setEditable(false);

        txtCidade.setEditable(false);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado)
                            .addComponent(lblCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCidade))))
                .addContainerGap())
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed

        // Incluir
        if (btnIncluir.getText().equals(BTN_INCLUIR)) {
            btnIncluir.setActionCommand(FCN_BTN_ADICIONAR);
            btnIncluir.setText(BTN_GRAVAR);
            btnEditar.setText(BTN_CANCELAR);
            
            cbxEstado.setModel(modelCombo);

            btnExcluir.setEnabled(false);
            btnLocalizar.setEnabled(false);

            setEditableFields(true);
            clearFields();

            txtCidade.requestFocus(true);

        } else {
            // Incluir novo registro
            if (btnIncluir.getActionCommand().equals(FCN_BTN_ADICIONAR)) {
                createCidade();
            } else { // Atualiza registro existente
                updateCidade();
            }
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditar.getText().equals(BTN_EDITAR)) {
            if(!hasSelectedItem()) {
                return;
            }

            btnEditar.setText(BTN_CANCELAR);
            btnIncluir.setText(BTN_GRAVAR);
            btnIncluir.setActionCommand(FCN_BTN_ATUALIZAR);

            btnExcluir.setEnabled(false);
            btnLocalizar.setEnabled(false);

            setEditableFields(true);
        } else if (btnEditar.getText().equals(BTN_CANCELAR)) {
            btnInit();
            clearFields();
            setEditableFields(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(!hasSelectedItem()) {
            return;
        }

        if(hasSure("Deseja excluir a Cidade " + txtCidade.getText() + "?")) {
            return;
        }

        try {
            Cidade cidade = new Cidade();
            cidade.setCidId(Integer.valueOf(txtCodigo.getText()));

            CidadeController cidController = new CidadeController(cidade);
            cidController.remove(cidade.getCidId());

            removeTableRow(model, indiceSelect);

            Message.show("Cidade removida com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            Message.show("Cidade não foi removida.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CidadeView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            clearFields();
            setEditableFields(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed

    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void createComboEstado() {

        if (listEstado == null || map == null) {
            map = new HashMap<String, Object>();
            listEstado = new ArrayList<Estado>();
            EstadoController estadoController = new EstadoController(new Estado());
            listEstado = estadoController.findEntities();
        }

        for (Estado estado : listEstado) {
            final String elCombo = estado.getEstId() + " - " + estado.getEstNome();
            modelCombo.addElement(elCombo);
            map.put(elCombo, estado);
        }
    }
    
    private void createCidade() {
        try {

            Cidade cidade = new Cidade();
            cidade.setEstId(getSelectedItemCombo(cbxEstado));
            cidade.setCidNome(txtCidade.getText());

            CidadeController cidadeController = new CidadeController(cidade);
            Cidade cidRetorno = cidadeController.create();
            txtCodigo.setText(cidRetorno.getCidId().toString());

            addTableRow(cidRetorno, model);

            btnInit();
            setEditableFields(false);

            Message.show("Cidade cadastrada com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Cidade não foi cadastrada.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CidadeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateCidade() {
        try {
            Cidade cidade = new Cidade();
            cidade.setCidId(Integer.valueOf(txtCodigo.getText()));
            cidade.setEstId(getSelectedItemCombo(cbxEstado));
            cidade.setCidNome(txtCidade.getText());

            CidadeController cidController = new CidadeController(cidade);
            Cidade cidRetorno = cidController.edit();

            btnInit();
            setEditableFields(false);
            
            updateTableRow(model, indiceSelect, cidRetorno);

            Message.show("Cidade alterada com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Cidade não foi alterada.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CidadeView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Função principal para criação da tabela de Cidade.
     */
    private void createTable() {
        table = new JTable(model);
        model.addColumn("Código");
        model.addColumn("Estado");
        model.addColumn("Cidade");

        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
                int indice = table.getSelectedRow();
                indiceSelect = indice;

                if (e.getValueIsAdjusting()) {
                    txtCodigo.setText(table.getValueAt(indice, 0).toString());
                    String strColumnEstado = table.getValueAt(indice, 1).toString();
                    String codStr = strColumnEstado.substring(0, strColumnEstado.trim().indexOf("-") - 1);
                    
                    String itemSelected = "";
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String strKey = entry.getKey();
                        String codStrKey = strKey.substring(0, strKey.trim().indexOf("-") - 1);
                        
                        if (codStr.equals(codStrKey)) {
                            itemSelected = strKey;
                            break;
                        }
                    }
                    
                    cbxEstado.getModel().setSelectedItem(itemSelected);
                    txtCidade.setText(table.getValueAt(indice, 2).toString());
                }

            }
        });
        
        populateTable(model);
        
    }
    
    private boolean hasSelectedItem() {
        
        if (txtCodigo.getText().trim().equals("")) {
            Message.show("Necessário selecionar a Cidade na tabela.", Message.MSG_ATENCAO, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }

    /**
     * Seta se os campos Estado e Sigla são editáveis de acordo com o parâmetro.
     * @param b 
     */
    private void setEditableFields(boolean b) {
        cbxEstado.setEnabled(b);
        txtCidade.setEditable(b);
    }

    /**
     * Retorna o menu de botões ao seu estado inicial.
     */
    private void btnInit() {
        btnIncluir.setText(BTN_INCLUIR);
        btnEditar.setText(BTN_EDITAR);
        
        btnIncluir.setEnabled(true);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnLocalizar.setEnabled(true);
    }
    
    /**
     * Preenche a tabela com os dados recuperados do banco de dados, através
     * de um findAll() da entidade Cidade.
     * @param model 
     */
    private void populateTable(DefaultTableModel model) {
        CidadeController cidadeController = new CidadeController(new Cidade());
        List<Cidade> listCidades = cidadeController.findEntities();

        for (Cidade cidade : listCidades) {
            addTableRow(cidade, model);
        }
    }
    
    /**
     * Limpam os campos: código, estado e cidade.
     */
    private void clearFields() {
        txtCodigo.setText("");
        cbxEstado.repaint();
        txtCidade.setText("");
    }
    
    /**
     * Adiciona na tabela
     * @param cidade
     * @param model 
     */
    private void addTableRow(Cidade cidade, DefaultTableModel model) {
        model.addRow(getObjectRow(cidade));
    }
    
    /**
     * Remove da tabela
     * @param model
     * @param indice 
     */
    private void removeTableRow(DefaultTableModel model, int indice) {
        model.removeRow(indice);
    }
    
    /**
     * Atualiza linha da tabela.
     */
    private void updateTableRow(DefaultTableModel model, int indice, Cidade cidade) {
        model.removeRow(indice);
        model.insertRow(indice, getObjectRow(cidade));
    }

    /**
     * Monta objeto para incluir na tabela.
     * 
     * @param cidade
     * @return 
     */
    private Object[] getObjectRow(Cidade cidade) {
        Estado estado = (Estado) getKeyValueMap(map, cidade.getEstId());
        return new Object[]{cidade.getCidId().toString(), estado.getEstId() + " - "
                    + estado.getEstSigla(), cidade.getCidNome()};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
