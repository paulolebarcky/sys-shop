package sys.shop.view;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sys.shop.controller.EstadoController;
import sys.shop.controller.exceptions.NonexistentEntityException;
import sys.shop.entity.Estado;
import sys.shop.util.Message;

/**
 * Trata a visão de estados.
 * 
 * @author paulo
 */
public class EstadoView extends DefaultView {
    
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable();
    private int indiceSelect;
    
    /**
     * Creates new form EstadoView
     */
    public EstadoView() {
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

        panelHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblSigla = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtSigla = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu = new javax.swing.JToolBar();
        btnIncluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/shop.png"))); // NOI18N
        jLabel4.setText("Cadastro de Estado");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblCodigo.setText("Código:");

        lblEstado.setText("Estado:");

        lblSigla.setText("Sigla:");

        txtCodigo.setEditable(false);

        txtEstado.setEditable(false);

        txtSigla.setEditable(false);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado)
                            .addComponent(lblSigla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSigla)
                    .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu.setFloatable(false);
        menu.setRollover(true);
        menu.setBorderPainted(false);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/add.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.setBorderPainted(false);
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        menu.add(btnIncluir);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        menu.add(btnEditar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/trash.gif"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(82, 36));
        btnExcluir.setMinimumSize(new java.awt.Dimension(82, 36));
        btnExcluir.setPreferredSize(new java.awt.Dimension(82, 36));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        menu.add(btnExcluir);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnSalvar.setBorderPainted(false);
        btnSalvar.setEnabled(false);
        btnSalvar.setMaximumSize(new java.awt.Dimension(82, 36));
        btnSalvar.setMinimumSize(new java.awt.Dimension(82, 36));
        btnSalvar.setPreferredSize(new java.awt.Dimension(82, 36));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        menu.add(btnSalvar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sys/shop/view/img/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnCancelar.setBorderPainted(false);
        btnCancelar.setEnabled(false);
        btnCancelar.setMaximumSize(new java.awt.Dimension(98, 36));
        btnCancelar.setMinimumSize(new java.awt.Dimension(98, 36));
        btnCancelar.setPreferredSize(new java.awt.Dimension(98, 36));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        menu.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setActionCommand(FCN_BTN_ADICIONAR);

        btnIncluir.setEnabled(false);
        btnEditar.setEnabled(false);

        btnExcluir.setEnabled(false);

        setEditableFields(true);
        clearFields();

        txtEstado.requestFocus(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if(!hasSelectedItem()) {
            return;
        }

        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setActionCommand(FCN_BTN_ATUALIZAR);

        btnIncluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);

        setEditableFields(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(!hasSelectedItem()) {
            return;
        }

        if(hasSure("Deseja excluir o Estado " + txtEstado.getText() + "?")) {
            return;
        }

        try {
            Estado estado = new Estado();
            estado.setEstId(Integer.valueOf(txtCodigo.getText()));

            EstadoController estadoController = new EstadoController(estado);
            estadoController.remove(estado.getEstId());

            removeTableRow(model, indiceSelect);
            
            Message.show("Estado removido com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            Message.show("Estado não foi removido.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(EstadoView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            clearFields();
            setEditableFields(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (btnSalvar.getActionCommand().equals(FCN_BTN_ADICIONAR)) {
            createEstado();
        } else { // Atualiza registro existente
            updateEstado();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnInit();
        clearFields();
        setEditableFields(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void createEstado() {
        try {

            Estado estado = new Estado();
            estado.setEstNome(txtEstado.getText());
            estado.setEstSigla(txtSigla.getText());

            EstadoController estadoController = new EstadoController(estado);
            Estado estRetorno = estadoController.create();
            txtCodigo.setText(estRetorno.getEstId().toString());

            addTableRow(estRetorno, model);

            btnInit();
            setEditableFields(false);

            Message.show("Estado cadastrado com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Estado não foi cadastrado.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(EstadoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateEstado() {
        try {
            Estado estado = new Estado();
            estado.setEstId(Integer.valueOf(txtCodigo.getText()));
            estado.setEstNome(txtEstado.getText());
            estado.setEstSigla(txtSigla.getText());

            EstadoController estadoController = new EstadoController(estado);
            Estado estRetorno = estadoController.edit();

            btnInit();
            setEditableFields(false);
            
            updateTableRow(model, indiceSelect, estRetorno);

            Message.show("Estado alterado com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Estado não foi alterado.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(EstadoView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Função principal para criação da tabela de Estado.
     */
    private void createTable() {
        table = new JTable(model);
        model.addColumn("Código");
        model.addColumn("Estado");
        model.addColumn("Sigla");

        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
                int indice = table.getSelectedRow();
                indiceSelect = indice;

                if (e.getValueIsAdjusting()) {
                    txtCodigo.setText(table.getValueAt(indice, 0).toString());
                    txtEstado.setText(table.getValueAt(indice, 1).toString());
                    txtSigla.setText(table.getValueAt(indice, 2).toString());
                }

            }
        });
        
        populateTable(model);
        
    }
    
    private boolean hasSelectedItem() {
        
        if (txtCodigo.getText().trim().equals("")) {
            Message.show("Necessário selecionar o Estado na tabela.", Message.MSG_ATENCAO, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }

    /**
     * Seta se os campos Estado e Sigla são editáveis de acordo com o parâmetro.
     * @param b 
     */
    private void setEditableFields(boolean b) {
        txtEstado.setEditable(b);
        txtSigla.setEditable(b);
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
    }
    
    /**
     * Preenche a tabela com os dados recuperados do banco de dados, através
     * de um findAll() da entidade  Estado.
     * @param model 
     */
    private void populateTable(DefaultTableModel model) {
        EstadoController estadoController = new EstadoController(new Estado());
        List<Estado> listEstados = estadoController.findEntities();

        for (Estado estado : listEstados) {
            model.addRow(new Object[]{estado.getEstId().toString(), estado.getEstNome(), estado.getEstSigla()});
        }
    }
    
    /**
     * Limpam os campos: código, estado e sigla.
     */
    private void clearFields() {
        txtCodigo.setText("");
        txtEstado.setText("");
        txtSigla.setText("");
    }
    
    /**
     * Adiciona na tabela
     * @param estado
     * @param model 
     */
    private void addTableRow(Estado estado, DefaultTableModel model) {
        model.addRow(new Object[]{estado.getEstId().toString(), estado.getEstNome(), estado.getEstSigla()});
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
    private void updateTableRow(DefaultTableModel model, int indice, Estado estado) {
        model.removeRow(indice);
        model.insertRow(indice, new Object[]{estado.getEstId().toString(), estado.getEstNome(), estado.getEstSigla()});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblSigla;
    private javax.swing.JToolBar menu;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
