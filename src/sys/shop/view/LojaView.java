package sys.shop.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sys.shop.controller.CidadeController;
import sys.shop.controller.LojaController;
import sys.shop.controller.exceptions.NonexistentEntityException;
import sys.shop.entity.Cidade;
import sys.shop.entity.Loja;
import sys.shop.util.Message;

/**
 *
 * @author paulo
 */
public class LojaView extends DefaultView {
    
    private DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
    private Map<String, Object> map;
    
    /**
     * Creates new form LojaView
     */
    public LojaView() {
        createComboCidade();
        initComponents();
        cbxCidade.setModel(modelCombo);
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
        lblNome = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        lblEndNumero = new javax.swing.JLabel();
        txtEndNumero = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        cbxCidade = new javax.swing.JComboBox();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        lblCel = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        ckbStatus = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Loja"));

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

        lblNome.setText("Nome:");

        lblTel.setText("Tel:");

        txtCodigo.setEditable(false);

        txtTel.setEditable(false);

        txtNome.setEditable(false);

        lblEndereco.setText("End:");

        txtEndereco.setEditable(false);

        jLabel1.setText("CEP:");

        txtCep.setEditable(false);

        lblEndNumero.setText("Nº:");

        txtEndNumero.setEditable(false);

        lblBairro.setText("Bairro:");

        txtBairro.setEditable(false);

        lblCidade.setText("Cidade:");

        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCnpj.setText("CNPJ:");

        txtCnpj.setEditable(false);
        txtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnpjActionPerformed(evt);
            }
        });

        lblCel.setText("Cel:");

        txtCel.setEditable(false);

        lblStatus.setText("Status:");

        ckbStatus.setText("ativa");

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
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelContentLayout.createSequentialGroup()
                                .addComponent(lblCnpj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCnpj))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContentLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCidade)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblNome)
                                .addComponent(lblTel))
                            .addComponent(lblEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEndNumero, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(5, 5, 5)
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContentLayout.createSequentialGroup()
                                .addComponent(txtEndNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lblBairro)
                                .addGap(6, 6, 6)
                                .addComponent(txtBairro))
                            .addComponent(txtEndereco)
                            .addComponent(txtNome)
                            .addGroup(panelContentLayout.createSequentialGroup()
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCel)
                                .addGap(4, 4, 4)
                                .addComponent(txtCel)))))
                .addContainerGap())
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(ckbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCel)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndNumero)
                    .addComponent(txtEndNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnpj)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed

        // Incluir
        if (btnIncluir.getText().equals(BTN_INCLUIR)) {
            btnIncluir.setActionCommand(FCN_BTN_ADICIONAR);
            btnIncluir.setText(BTN_GRAVAR);
            btnEditar.setText(BTN_CANCELAR);

            cbxCidade.setModel(modelCombo);

            btnExcluir.setEnabled(false);
            btnLocalizar.setEnabled(false);

            setEditableFields(true);
            clearFields();

            txtTel.requestFocus(true);

        } else {
            // Incluir novo registro
            if (btnIncluir.getActionCommand().equals(FCN_BTN_ADICIONAR)) {
                createLoja();
            } else { // Atualiza registro existente
                updateLoja();
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

        if(hasSure("Deseja excluir a Loja " + txtNome.getText() + "?")) {
            return;
        }

        try {
            Loja loja = new Loja();
            loja.setLojId(Integer.valueOf(txtCodigo.getText()));

            LojaController cidController = new LojaController(loja);
            cidController.remove(loja.getCidId());
            
            Message.show("Loja removida com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            Message.show("Loja não foi removida.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LojaView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            clearFields();
            setEditableFields(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        new LocalizarView().setVisible(true);
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void txtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnpjActionPerformed

    
    private void createComboCidade() {
        if (map == null) {
            map = getMapComboCidade();
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String string = entry.getKey();
            modelCombo.addElement(string);
        }
    }
    
    private void createLoja() {
        try {
            Loja loja = mountObjectLoja();

            LojaController lojaController = new LojaController(loja);
            Loja lojaRetorno = lojaController.create();
            txtCodigo.setText(lojaRetorno.getLojId().toString());

            btnInit();
            setEditableFields(false);

            Message.show("Loja cadastrada com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Loja não foi cadastrada.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LojaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateLoja() {
        try {
            Loja loja = mountObjectLoja();

            LojaController lojaController = new LojaController(loja);
            lojaController.edit();

            btnInit();
            setEditableFields(false);

            Message.show("Loja alterada com sucesso.", Message.MSG_SUCESSO, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Message.show("Loja não foi alterada.", Message.MSG_FALHA, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LojaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private boolean hasSelectedItem() {
        
        if (txtCodigo.getText().trim().equals("")) {
            Message.show("Necessário selecionar a loja na tabela.", Message.MSG_ATENCAO, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }

    /**
     * Seta se os campos da tela como editáveis ou não, de acordo com o parâmetro.
     * @param b 
     */
    private void setEditableFields(boolean b) {
        txtNome.setEditable(b);
        txtBairro.setEditable(b);
        txtCel.setEditable(b);
        txtCep.setEditable(b);
        txtCnpj.setEditable(b);
        txtEndNumero.setEditable(b);
        txtEndereco.setEditable(b);
        txtTel.setEditable(b);
        cbxCidade.setEditable(b);
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
     * Limpam os campos da tela
     */
    private void clearFields() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtBairro.setText("");
        txtCel.setText("");
        txtCep.setText("");
        txtCnpj.setText("");
        txtEndNumero.setText("");
        txtEndereco.setText("");
        txtTel.setText("");
        cbxCidade.repaint();
    }
    
    private char isSelected(JCheckBox ckb) {
        return ckb.isSelected() == true ? '1' : '0';
    }
    
    private Loja mountObjectLoja() {
        Loja loja = new Loja();
        
        Integer codLoja = txtCodigo.getText().trim().equals("") ? 
                null : Integer.valueOf(txtCodigo.getText());
        
        loja.setLojId(codLoja);
        loja.setLojNome(txtNome.getText());
        loja.setLojStatus(isSelected(ckbStatus));
        loja.setLojEndereco(txtEndereco.getText());
        loja.setLojBairro(txtBairro.getText());
        loja.setLojCelular(txtCel.getText());
        loja.setLojCnpj(txtCnpj.getText());
        loja.setLojCep(txtCep.getText());
        loja.setLojTelefone(txtTel.getText());
        loja.setCidId(getSelectedItemCombo(cbxCidade));
        
        return loja;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JCheckBox ckbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEndNumero;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTel;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEndNumero;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
