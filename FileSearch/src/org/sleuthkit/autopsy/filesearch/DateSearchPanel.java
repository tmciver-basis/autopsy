/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sleuthkit.autopsy.filesearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Subpanel with controls for file data filtering.
 */
class DateSearchPanel extends javax.swing.JPanel {

    DateFormat dateFormat;
    List<String> timeZones;

    DateSearchPanel(DateFormat dateFormat, List<String> timeZones) {
        this.dateFormat = dateFormat;
        this.timeZones = timeZones;

        initComponents();
        customizeComponents();
    }
    
    private void customizeComponents(){
        
        dateFromTextField.setComponentPopupMenu(rightClickMenu);
        dateToTextField.setComponentPopupMenu(rightClickMenu);
        ActionListener actList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JMenuItem jmi = (JMenuItem) e.getSource();
                /* Because there are two text fields, we have to determine which invoked the popupmenu */
                JFormattedTextField jftf = (JFormattedTextField) ((JPopupMenu) jmi.getParent()).getInvoker();
                if(jmi.equals(cutMenuItem))
                    jftf.cut();
                else if(jmi.equals(copyMenuItem))
                    jftf.copy();
                else if(jmi.equals(pasteMenuItem))
                    jftf.paste();
                else if(jmi.equals(selectAllMenuItem))
                    jftf.selectAll();
            }
        };
        cutMenuItem.addActionListener(actList);
        copyMenuItem.addActionListener(actList);
        pasteMenuItem.addActionListener(actList);
        selectAllMenuItem.addActionListener(actList);

    }

    JCheckBox getAccessedCheckBox() {
        return accessedCheckBox;
    }

    JCheckBox getChangedCheckBox() {
        return changedCheckBox;
    }

    JCheckBox getCreatedCheckBox() {
        return createdCheckBox;
    }

    JCheckBox getDateCheckBox() {
        return dateCheckBox;
    }

    JFormattedTextField getDateFromTextField() {
        return dateFromTextField;
    }

    JFormattedTextField getDateToTextField() {
        return dateToTextField;
    }

    JCheckBox getModifiedCheckBox() {
        return modifiedCheckBox;
    }

    JComboBox getTimeZoneComboBox() {
        return timeZoneComboBox;
    }

    void setTimeZones(List<String> newTimeZones) {
        this.timeZones = newTimeZones;
        this.timeZoneComboBox.removeAllItems();
        for (String tz : newTimeZones) {
            this.timeZoneComboBox.addItem(tz);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        selectAllMenuItem = new javax.swing.JMenuItem();
        dateToTextField = new JFormattedTextField(this.dateFormat);
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateCheckBox = new javax.swing.JCheckBox();
        timeZoneComboBox = new JComboBox(this.timeZones.toArray());
        timeZoneComboBox.setRenderer(new DateSearchFilter.ComboBoxRenderer());
        jLabel3 = new javax.swing.JLabel();
        dateFromTextField = new JFormattedTextField(this.dateFormat);
        jLabel2 = new javax.swing.JLabel();
        dateFromButtonCalendar = new org.sourceforge.jcalendarbutton.JCalendarButton();
        modifiedCheckBox = new javax.swing.JCheckBox();
        changedCheckBox = new javax.swing.JCheckBox();
        accessedCheckBox = new javax.swing.JCheckBox();
        createdCheckBox = new javax.swing.JCheckBox();
        dateToButtonCalendar = new org.sourceforge.jcalendarbutton.JCalendarButton();

        cutMenuItem.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.cutMenuItem.text")); // NOI18N
        rightClickMenu.add(cutMenuItem);

        copyMenuItem.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.copyMenuItem.text")); // NOI18N
        rightClickMenu.add(copyMenuItem);

        pasteMenuItem.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.pasteMenuItem.text")); // NOI18N
        rightClickMenu.add(pasteMenuItem);

        selectAllMenuItem.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.selectAllMenuItem.text")); // NOI18N
        rightClickMenu.add(selectAllMenuItem);

        dateToTextField.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.dateToTextField.text")); // NOI18N
        dateToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateToTextFieldFocusLost(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.jLabel1.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.jLabel4.text")); // NOI18N

        dateCheckBox.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.dateCheckBox.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.jLabel3.text")); // NOI18N

        dateFromTextField.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.dateFromTextField.text")); // NOI18N
        dateFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFromTextFieldFocusLost(evt);
            }
        });

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.jLabel2.text")); // NOI18N

        dateFromButtonCalendar.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.dateFromButtonCalendar.text")); // NOI18N
        dateFromButtonCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFromPopupChanged(evt);
            }
        });

        modifiedCheckBox.setSelected(true);
        modifiedCheckBox.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.modifiedCheckBox.text")); // NOI18N

        changedCheckBox.setSelected(true);
        changedCheckBox.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.changedCheckBox.text")); // NOI18N

        accessedCheckBox.setSelected(true);
        accessedCheckBox.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.accessedCheckBox.text")); // NOI18N

        createdCheckBox.setSelected(true);
        createdCheckBox.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.createdCheckBox.text")); // NOI18N

        dateToButtonCalendar.setText(org.openide.util.NbBundle.getMessage(DateSearchPanel.class, "DateSearchPanel.dateToButtonCalendar.text")); // NOI18N
        dateToButtonCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateToPopupChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dateCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dateFromButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dateToButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changedCheckBox)
                            .addComponent(modifiedCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accessedCheckBox)
                            .addComponent(createdCheckBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeZoneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateCheckBox)
                        .addComponent(dateFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dateToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dateToButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))
                        .addComponent(dateFromButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(timeZoneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifiedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changedCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accessedCheckBox)
                        .addGap(23, 23, 23))
                    .addComponent(createdCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFromTextFieldFocusLost
        // set the "from" calendar button to listen to change in the text field
        String fromDateString = this.dateFromTextField.getText();
        if (!fromDateString.equals("")) {
            try {
                Date fromDate = dateFormat.parse(fromDateString);
                dateFromButtonCalendar.setTargetDate(fromDate);
            } catch (ParseException ex) {
                // for now, no need to show the error message to the user her
            }
        }
    }//GEN-LAST:event_dateFromTextFieldFocusLost

    private void dateToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateToTextFieldFocusLost
        // set the "to" calendar button to listen to change in the text field
        String toDateString = this.dateToTextField.getText();
        if (!toDateString.equals("")) {
            try {
                Date toDate = dateFormat.parse(toDateString);
                dateToButtonCalendar.setTargetDate(toDate);
            } catch (ParseException ex) {
                // for now, no need to show the error message to the user here
            }
        }
    }//GEN-LAST:event_dateToTextFieldFocusLost

    private void dateFromPopupChanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFromPopupChanged
        if (evt.getNewValue() instanceof Date) {
            setFromDate((Date) evt.getNewValue());
        }
    }//GEN-LAST:event_dateFromPopupChanged

    private void dateToPopupChanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateToPopupChanged
        if (evt.getNewValue() instanceof Date) {
            setToDate((Date) evt.getNewValue());
        }
    }//GEN-LAST:event_dateToPopupChanged

    /**
     * Validate and set the datetime field on the screen given a datetime string.
     * @param date The date object
     */
    private void setFromDate(Date date) {
        String dateStringResult = "";
        if (date != null) {
            dateStringResult = dateFormat.format(date);
        }
        dateFromTextField.setText(dateStringResult);
        dateFromButtonCalendar.setTargetDate(date);
    }

    /**
     * Validate and set the datetime field on the screen given a date.
     * @param date The date object
     */
    private void setToDate(Date date) {
        String dateStringResult = "";
        if (date != null) {
            dateStringResult = dateFormat.format(date);
        }
        dateToTextField.setText(dateStringResult);
        dateToButtonCalendar.setTargetDate(date);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox accessedCheckBox;
    private javax.swing.JCheckBox changedCheckBox;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JCheckBox createdCheckBox;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JCheckBox dateCheckBox;
    private org.sourceforge.jcalendarbutton.JCalendarButton dateFromButtonCalendar;
    private javax.swing.JFormattedTextField dateFromTextField;
    private org.sourceforge.jcalendarbutton.JCalendarButton dateToButtonCalendar;
    private javax.swing.JFormattedTextField dateToTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox modifiedCheckBox;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JMenuItem selectAllMenuItem;
    private javax.swing.JComboBox timeZoneComboBox;
    // End of variables declaration//GEN-END:variables

    void addActionListener(ActionListener l) {
        dateFromTextField.addActionListener(l);
        dateToTextField.addActionListener(l);
    }
}
