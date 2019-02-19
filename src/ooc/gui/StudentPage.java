/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import ooc.Books;
import ooc.DBConnector;

/**
 *
 * @author Kevin
 */
public class StudentPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentPage
     */
    
    Connection conn = null;
    PreparedStatement pststmt = null;
    ResultSet rs = null;
    
    public StudentPage() {
        initComponents();
        setTitle("Student Page");
    }
    
    public ArrayList<Books> ListBooks(String searchBN, String searchAN, String searchG) {
        ArrayList<Books> bookList = new ArrayList<Books>();
        String query = "select * from book";
        
        if (!searchBN.equals("") && !searchBN.equals("Book Name Here") ) {
            
            String query1 = "select * from book where title='" + searchBN + "'";
            
            try {
                conn = DBConnector.connectDB();
                pststmt = conn.prepareStatement(query1);
            
                rs = pststmt.executeQuery();
                
                Books book;
                
                while (rs.next()) {
                    book = new Books(
                        rs.getString("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author_name"),
                        rs.getString("genre"),
                        rs.getString("availability")
                    );
                    bookList.add(book);
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else if (!searchAN.equals("") && !searchAN.equals("Author Name Here")) {
            
            String query2 = "select * from book where author_name='" + searchAN + "'";
            
            try {
                conn = DBConnector.connectDB();
                pststmt = conn.prepareStatement(query2);
            
                rs = pststmt.executeQuery();
                
                Books book;
                
                while (rs.next()) {
                    book = new Books(
                        rs.getString("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author_name"),
                        rs.getString("genre"),
                        rs.getString("availability")
                    );
                    bookList.add(book);
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } 
        else if (!searchG.equals("") && !searchG.equals("Genre Here")) {
            
            String query3 = "select * from book where genre='" + searchG + "'";
            
            try {
                conn = DBConnector.connectDB();
                pststmt = conn.prepareStatement(query3);
            
                rs = pststmt.executeQuery();
                
                Books book;
                
                while (rs.next()) {
                    book = new Books(
                        rs.getString("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author_name"),
                        rs.getString("genre"),
                        rs.getString("availability")
                    );
                    bookList.add(book);
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            
            try {
                conn = DBConnector.connectDB();
                pststmt = conn.prepareStatement(query);
            
                rs = pststmt.executeQuery();
                
                Books book;
                
                while (rs.next()) {
                    book = new Books(
                        rs.getString("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author_name"),
                        rs.getString("genre"),
                        rs.getString("availability")
                    );
                    bookList.add(book);
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
//        if (searchBN.equals("") || searchBN.equals("Book Name Here") &&
//               searchAN.equals("") || searchAN.equals("Author Name Here") &&
//               searchG.equals("") || searchG.equals("Genre Here")) 
//        {
//            
//            query = "select * from book";
//            
//        }
        
        return bookList;
    }
    
     public void findBooks() {
        ArrayList<Books> books = ListBooks(searchBook.getText(), searchAuthor.getText(), searchGenre.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"Book ID","ISBN","Title","Author Name","Genre","Availability"});
        Object[] row = new Object[6];
        
        for (int i = 0; i < books.size(); i++) {
            row[0] = books.get(i).getBook_Id();
            row[1] = books.get(i).getIsbn();
            row[2] = books.get(i).getTitle();
            row[3] = books.get(i).getAuthor_Name();
            row[4] = books.get(i).getGenre();
            row[5] = books.get(i).getAvailability();
            model.addRow(row);
        }
        bookTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentPagePanel = new javax.swing.JPanel();
        navBarPanel = new javax.swing.JPanel();
        navLabel = new javax.swing.JLabel();
        serachBooks = new javax.swing.JButton();
        listOfIssued = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bookLabel = new javax.swing.JLabel();
        searchBook = new javax.swing.JTextField();
        serachBookName1 = new javax.swing.JLabel();
        searchAuthor = new javax.swing.JTextField();
        serachBookName2 = new javax.swing.JLabel();
        searchGenre = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        listPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));

        studentPagePanel.setBackground(new java.awt.Color(255, 255, 255));
        studentPagePanel.setMaximumSize(new java.awt.Dimension(700, 584));
        studentPagePanel.setMinimumSize(new java.awt.Dimension(700, 584));

        navLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        navLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navLabel.setText("Navigation Panel");

        serachBooks.setText("Search And Reserve Books");
        serachBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serachBooksActionPerformed(evt);
            }
        });

        listOfIssued.setText("Extend Books Issued");
        listOfIssued.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOfIssuedMouseClicked(evt);
            }
        });
        listOfIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfIssuedActionPerformed(evt);
            }
        });

        logoutButton.setText("LogOut");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navBarPanelLayout = new javax.swing.GroupLayout(navBarPanel);
        navBarPanel.setLayout(navBarPanelLayout);
        navBarPanelLayout.setHorizontalGroup(
            navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listOfIssued, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serachBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        navBarPanelLayout.setVerticalGroup(
            navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serachBooks)
                .addGap(18, 18, 18)
                .addComponent(listOfIssued)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        resultPanel.setBackground(new java.awt.Color(0, 204, 204));
        resultPanel.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search for Books");

        bookLabel.setText("Book Name:");

        serachBookName1.setText("Author Name:");

        serachBookName2.setText("Genre:");

        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                .addComponent(serachBookName2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                .addComponent(bookLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(serachBookName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchAuthor)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookLabel)
                    .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serachBookName1)
                    .addComponent(searchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serachBookName2)
                    .addComponent(searchGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        resultPanel.add(searchPanel, "card2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("List of Books you currently have Issued");

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "ISBN", "Title", "Day Of Issue", "Due Date", "Extended"
            }
        ));
        issueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(issueTable);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        resultPanel.add(listPanel, "card2");

        javax.swing.GroupLayout studentPagePanelLayout = new javax.swing.GroupLayout(studentPagePanel);
        studentPagePanel.setLayout(studentPagePanelLayout);
        studentPagePanelLayout.setHorizontalGroup(
            studentPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        studentPagePanelLayout.setVerticalGroup(
            studentPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentPagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentPagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serachBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serachBooksActionPerformed
        // TODO add your handling code here:
        
        //removeing panels
        resultPanel.removeAll();
        resultPanel.repaint();
        resultPanel.revalidate();
        //adding panels
        resultPanel.add(searchPanel);
        resultPanel.repaint();
        resultPanel.revalidate();
    }//GEN-LAST:event_serachBooksActionPerformed

    private void listOfIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfIssuedActionPerformed
        // TODO add your handling code here:
        //removeing panels
        resultPanel.removeAll();
        resultPanel.repaint();
        resultPanel.revalidate();
        //adding panels
        resultPanel.add(listPanel);
        resultPanel.repaint();
        resultPanel.revalidate();
    }//GEN-LAST:event_listOfIssuedActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        SignIn signin = new SignIn();
        signin.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        findBooks();
    }//GEN-LAST:event_searchButtonMouseClicked
    
    ReservePopUp popup = new ReservePopUp();
    
    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        // TODO add your handling code here:
        int index = bookTable.getSelectedRow();
        TableModel model = bookTable.getModel();
        String bookId = model.getValueAt(index, 0).toString();
        String isbn = model.getValueAt(index, 1).toString();
        String title = model.getValueAt(index, 2).toString();
        String authorName = model.getValueAt(index, 3).toString();
        String genre = model.getValueAt(index, 4).toString();
        String avail = model.getValueAt(index, 5).toString();
        
        if (avail.equalsIgnoreCase("Yes")) {
            popup.setVisible(true);
            popup.pack();
            popup.setLocationRelativeTo(null);
            popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            popup.bookIDField.setText(bookId);
            popup.isbnField.setText(isbn);
            popup.titleField.setText(title);
            popup.authorField.setText(authorName);
            popup.genreField.setText(genre);
            popup.availField.setText(avail);
        } else {
            JOptionPane.showMessageDialog(null, "Book not Available");
        }
        

        
    }//GEN-LAST:event_bookTableMouseClicked

    private void listOfIssuedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOfIssuedMouseClicked
        // TODO add your handling code here:
        conn = DBConnector.connectDB();
        fetchData();
    }//GEN-LAST:event_listOfIssuedMouseClicked
    
    PopUpExtention pop = new PopUpExtention();
    
    private void issueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueTableMouseClicked
        // TODO add your handling code here:
        int index = issueTable.getSelectedRow();
        TableModel model = issueTable.getModel();
        String rbID = model.getValueAt(index, 0).toString();
        String bookID = model.getValueAt(index, 1).toString();
        String isbn = model.getValueAt(index, 2).toString();
        String title = model.getValueAt(index, 3).toString();
        String dayOfIssue = model.getValueAt(index, 4).toString();
        String dueDate = model.getValueAt(index, 5).toString();
        String dayOfReturn = model.getValueAt(index, 6).toString();
        String fee = model.getValueAt(index, 7).toString();
        String extended = model.getValueAt(index, 8).toString();
        
        if (extended.equalsIgnoreCase("No")) {
            pop.setVisible(true);
            pop.pack();
            pop.setLocationRelativeTo(null);
            pop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            pop.rbIDField.setText(rbID);
            pop.bookIDField.setText(bookID);
            pop.isbnField.setText(isbn);
            pop.titleField.setText(title);
            pop.dayOfIssueField.setText(dayOfIssue);
            pop.dueDateField.setText(dueDate);
            pop.returnDayField.setText(dayOfReturn);
            pop.feeField.setText(fee);
            pop.statusField.setText(extended);
        } else {
            JOptionPane.showMessageDialog(null, "Book not Available");
        }
    }//GEN-LAST:event_issueTableMouseClicked
    
    public void fetchData(){
        try{
            String query = "select * from student where rb_id='" + SignIn.HOLDID + "' and day_of_return='null'";
            pststmt = conn.prepareStatement(query);
            rs = pststmt.executeQuery();
            
            issueTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPage().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookLabel;
    public javax.swing.JTable bookTable;
    private javax.swing.JTable issueTable;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton listOfIssued;
    private javax.swing.JPanel listPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel navBarPanel;
    private javax.swing.JLabel navLabel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JTextField searchAuthor;
    private javax.swing.JTextField searchBook;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchGenre;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel serachBookName1;
    private javax.swing.JLabel serachBookName2;
    private javax.swing.JButton serachBooks;
    private javax.swing.JPanel studentPagePanel;
    // End of variables declaration//GEN-END:variables
}
