/*
 * This file is part of Greta.
 *
 * Greta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Greta.  If not, see <https://www.gnu.org/licenses/>.
 *
 */
package greta.application.modular.tools;

import greta.application.modular.ModularXMLFile;
import greta.core.util.xml.XMLTree;
import java.awt.event.ItemEvent;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Andre-Marie Pez
 */
public class DependencePanel extends javax.swing.JPanel {


    private LibEditor parentEditor;
    private XMLTree dependsTree;

    /**
     * Creates new form DependencePanel
     */
    public DependencePanel() {
        initComponents();
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if(dependsTree !=null){
                        dependsTree.setAttribute("lib_id", jComboBox1.getSelectedItem().toString());
                        updateLibComboboxSelection();
                    }
                }
            }
        });
    }

    public DependencePanel(XMLTree depends, LibEditor parentEditor) {
        this();
        setParentEditor(parentEditor);
        setDependence(depends);
    }

    public final void setDependence(XMLTree depends){
        dependsTree = null;
        String currentLib = depends.getParent().getAttribute("id");
        setupLibCombobox(currentLib);
        dependsTree = depends;
        updateLibComboboxSelection();
    }

    public final void setParentEditor(LibEditor parentEditor){
        this.parentEditor = parentEditor;
    }

    private void setupLibCombobox(String ignore){
        jComboBox1.removeAllItems();

        if(ModularXMLFile.getRoot()==null){
            return ;
        }
        LinkedList<String> libIds = new LinkedList<String>();
        for (XMLTree lib : ModularXMLFile.getLibs().getChildrenElement()) {
            if (lib.isNamed("lib")) {
                String lib_id = lib.getAttribute("id");
                if( ! ignore.equals(lib_id)){
                    libIds.add(lib.getAttribute("id"));
                }
            }
        }

        Collections.sort(libIds, String.CASE_INSENSITIVE_ORDER);
        libIds.addFirst("---");

        for (String lib_id : libIds) {
            jComboBox1.addItem(lib_id);
        }
    }

    private void updateLibComboboxSelection(){
        if (dependsTree != null){
            String lib_is = dependsTree.getAttribute("lib_id");
            if(((DefaultComboBoxModel)jComboBox1.getModel()).getIndexOf(lib_is)>=0) {
                jComboBox1.setSelectedItem(lib_is);
                jComboBox1.setForeground(Colors.normal);
            }
            else{
                jComboBox1.setSelectedIndex(0);
                jComboBox1.setForeground(Colors.error);
            }
        }
        else{
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setForeground(Colors.normal);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new greta.core.utilx.gui.ToolBox.LocalizedJButton("GUI.delete");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dependsTree.getParent().removeChild(dependsTree);
        parentEditor.updateDependenciesList();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration//GEN-END:variables
}
