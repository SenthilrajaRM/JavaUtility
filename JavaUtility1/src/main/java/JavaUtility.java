import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
//import java.awt.event.KeyEvent;


//import java.io.*;
//import java.nio.file.Files;
//import javax.swing.JTextField;
import javax.swing.*;




//import java.nio.file.*;
////import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
//import java.awt.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


import java.io.*;


import java.util.List;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;






public class JavaUtility extends JPanel{
        
    public JavaUtility() {
        super(new GridLayout(1, 1));
                JLabel label1;
//                JPanel panel;
                JTextField text1;
//                JPanel f;


        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("C:\\Users\\ABB2499\\Pictures\\middle.gif");
        
        tabbedPane.setBackground(Color.GRAY);
        tabbedPane.setForeground(Color.white);
        setPreferredSize(new Dimension(600, 420));
        


        JComponent panel1 = makeTextPanel1("Panel #1");
 
        tabbedPane.addTab("File Transfer", icon, panel1,
                          "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//        tabbedPane.setTabComponentAt(0, new JLabel("view files"));


        JComponent panel2 = makeTextPanel2("Panel #2");


        tabbedPane.addTab("PO Generation", icon, panel2,
                          "Does twice as much nothing");
                
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent panel3 = makeTextPanel3("Panel #3");


        tabbedPane.addTab("XML File Generation", icon, panel3,
                          "Does twice as much nothing");
                
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        JComponent panel4 = makeTextPanel4("Panel #4");
        tabbedPane.addTab("Expense Invoice Generation", icon, panel4,
                          "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);


//        JComponent panel5 = makeTextPanel(
//                "Panel #5 (has a preferred size of 410 x 50).");
//        panel4.setPreferredSize(new Dimension(410, 50));
//        tabbedPane.addTab("JBOSS MQ", icon, panel5,
//                          "Does nothing at all");
//        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);


        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //Uncomment the following line to use scrolling tabs.
        //tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }


    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    
    protected JComponent makeTextPanel2(String text) {
        JPanel panel = new JPanel(false);    
        JLabel filler1 = new JLabel(text);
        final JTextField textpath1 = new JTextField(18);
        
//        panel.setBackground(Color.RED);
        
        filler1.setText("Start PO No :");
        filler1.setBounds(60, 80, 120, 20);
        textpath1.setBounds(10, 10, 10, 3);
        
        JLabel filler2 = new JLabel(text);
        final JTextField textpath2 = new JTextField(18);
        textpath2.setBounds(10, 10, 10, 3);
        
        filler2.setText("End PO No :");
        filler2.setBounds(200, 140, 500, 20);
        
        JLabel Docpath = new JLabel(text);
        final JTextField Docpathtext = new JTextField(18);
        Docpathtext.setBounds(10,10,10,3);
        
        Docpath.setText("Document Path :");
        Docpath.setBounds(200,140,500,20);
        
        panel.add(filler1);
        panel.add(textpath1);
        panel.add(filler2);
        panel.add(textpath2);
        panel.add(Docpath);
        panel.add(Docpathtext);
        
        JButton btnTransfer=new JButton("Generate Text files");
                btnTransfer.setBounds(150,200,120, 40);
                panel.add(btnTransfer);
                
                btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    FileSystem fileSys = FileSystems.getDefault();
                        String value1=textpath1.getText();
                    String value2=textpath2.getText();
                    String value3=Docpathtext.getText();
                    int PONumber = Integer.parseInt(value1);
                    int Range1 = Integer.parseInt(value2);


                            int i=PONumber;
                    try {
                        
                                    for(;i<=Range1;i++) {
                        
//                        File file = new File("C:\\Users\\ABB2499\\Pictures\\Sample\\example"+i+".txt");
//                        File file = new File("S:\\HQ Common\\Wipro\\Softwares\\Jothiraman Ferguson\\Devi\\Sample"+i+".txt");
                        
                        File file = new File(value3+i+".txt");
                        System.out.println(file.toString());
                        
                        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
                        wr.write("DOC_HEADER                                                                                810                           01/17/201914056105593300                    6105593300     596                                               3001                FERININ FEIBP                         EC_WD_IN_INVOICE              WD                            A/P                           INVOICE                                                                    0000                          3001                3001                000255264 255264    552640009 01/17/201914055797223                       \r\n" + 
                                "INVOICE_HEADER                01/17/20195797223                  01/17/2019 PO"+ i +"                                                      DI     000630687                                                                                 345676                        \r\n" + 
                                "BILL_TO_ADDRESS                  Ferguson Enterprises-Portland       PO Box 9406                                                                                                                                      Hampton             VA 236700406   \r\n" + 
                                "REMIT_TO_ADDRESS                 VICTAULIC COMPANY                   PO Box 8538-203                                                                                                                                  Philadelphia        PA 19171-0203  \r\n" + 
                                "SHIP_TO_ADDRESS                  CONTROL FIRE SYSTEMS                4340 River Trail Way                                                                                                                             The Dalles          OR 970583537   \r\n" + 
                                "TERMS_OF_SALE                 ZZ 3  2      02/11/2019    02/25/2019     33366                                 2% 10th Prox                                 \r\n" + 
                                "PRODUCT                       1   1         1    584          126             S381PEQ410                    V3802175                                                    68830429087                   EA\r\n" + 
                                "PRODUCT_DESCRIPTION           V3802 K5.6 CNCL 175F/79C QR  ~                                                  \r\n" + 
                                "PRODUCT                       2   2         1    503          12.98           S3806D0040                    804301                                                      68830484305                   EA\r\n" + 
                                "PRODUCT_DESCRIPTION           V38 CNCL CVR 165F/74C WH                                                        \r\n" + 
                                "CARRIER_DETAIL                                                                      000000                                                               \r\n" + 
                                "INVOICE_TOTAL                 1668294     1668294     1634928     33366       \r\n" + 
                                "DOCUMENT_NOTE                 Please ship rings with 750's            \r\n" + 
                                "DOCUMENT_NOTE                 Created By: EDI         edited by JW    \r\n" + 
                                "DOCUMENT_NOTE                 WEIGHT: 220.000                         \r\n" + 
                                "DOCUMENT_NOTE                 VICTAULIC ORDER# 345676                 \r\n" + 
                                "DOCUMENT_NOTE                 000000                                  \r\n" + 
                                "DOC_TRAILER                   Batch # 48898 ");
                        wr.close();
                        }
//                        output.write(text);
                    } catch ( IOException e ) {
                        e.printStackTrace();
                    } finally {
//                      if ( output != null ) {
//                        output.close();
//                      }
                    }
                    
                    JFrame parent = new JFrame();
                            JOptionPane.showMessageDialog(parent, "Text document generated successfully");
                }
                    });
        return panel;
    }
    
    protected JComponent makeTextPanel1(String text) {
        JPanel panel = new JPanel(false);    
        JLabel filler3 = new JLabel(text);
        final JTextField textpath3 = new JTextField(10);
        
//        panel.setBackground(Color.GREEN);
        
        filler3.setText("Source path:");
        filler3.setBounds(60, 80, 120, 20);
        textpath3.setBounds(10, 10, 10, 3);
        
        JLabel filler4 = new JLabel(text);
        final JTextField textpath4 = new JTextField(10);
        textpath4.setBounds(10, 10, 10, 3);
        
        filler4.setText("Destination path:");
        filler4.setBounds(200, 140, 500, 20);
        panel.add(filler3);
        panel.add(textpath3);
        panel.add(filler4);
        panel.add(textpath4);
        
        JButton btnCreatenp=new JButton("Transfer Files");
        btnCreatenp.setBounds(150,200,120, 40);
                panel.add(btnCreatenp);
                
                btnCreatenp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileSystem fileSys = FileSystems.getDefault();
                String value1=textpath3.getText();
                String value2=textpath4.getText();
                Path srcPath = fileSys.getPath(value1);
                Path destPath = fileSys.getPath(value2);


                try {


                Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);


                //Files.move(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);


                }catch(IOException ioe) {
                  ioe.printStackTrace();
                }
                
                JFrame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "Files Transfered successfully");


            }
            });
        return panel;
    }
    
   
    protected JComponent makeTextPanel3(String text) {
        JPanel panel = new JPanel(false);    
        JLabel filler1 = new JLabel(text);
        final JTextField textpath1 = new JTextField(15);
        
//        panel.setBackground(Color.YELLOW);
        
        filler1.setText("Start CustAcc No :");
        filler1.setBounds(60, 80, 120, 20);
        textpath1.setBounds(10, 10, 10, 3);
        
        JLabel filler2 = new JLabel(text);
        final JTextField textpath2 = new JTextField(15);
        textpath2.setBounds(10, 10, 10, 3);
        
        filler2.setText("End CustAcc No :");
        filler2.setBounds(200, 140, 500, 20);
        
        JLabel Docpath2 = new JLabel(text);
        final JTextField Docpathtext2 = new JTextField(18);
        Docpathtext2.setBounds(10,10,10,3);
        
        Docpath2.setText("Document Path :");
        Docpath2.setBounds(200,140,500,20);
        
        panel.add(filler1);
        panel.add(textpath1);
        panel.add(filler2);
        panel.add(textpath2);
        panel.add(Docpath2);
        panel.add(Docpathtext2);
        
        JButton btnTransfer=new JButton("Generate XML files");
                btnTransfer.setBounds(150,200,120, 40);
                panel.add(btnTransfer);
                
                btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    FileSystem fileSys = FileSystems.getDefault();
                        String value1=textpath1.getText();
                    String value2=textpath2.getText();
                    String value3=Docpathtext2.getText();
                    int PONumber = Integer.parseInt(value1);
                    int Range1 = Integer.parseInt(value2);


                            int i=PONumber;
                    try {
                        
                                    for(;i<=Range1;i++) {
                        
//                        File file = new File("C:\\Users\\ABB2499\\Pictures\\Sample\\example"+i+".xml");
                        
                        File file = new File(value3+i+".xml");
                        
//                        File file = new File("S:\\HQ Common\\Wipro\\Softwares\\Jothiraman Ferguson\\Devi\\Sample"+i+".txt");
                        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
                        wr.write(" <?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
                                        "<SalesOrder xmlns=\"http://schemas.microsoft.com/dynamics/2008/01/documents/SalesOrder\">\r\n" + 
                                        "<SalesTable class=\"entity\">\r\n" + 
                                        "  <CustAccount>C"+i+"</CustAccount>\r\n" + 
                                        "  <DeliveryDate>2011-10-11</DeliveryDate>\r\n" + 
                                        "  <ReceiptDateRequested>2011-11-11</ReceiptDateRequested>\r\n" + 
                                        "  <PurchOrderFormNum>ABC-98654</PurchOrderFormNum>\r\n" + 
                                        "  <InventLocationId>EMU</InventLocationId>\r\n" + 
                                        "  <DeliveryName>Delivery name 465</DeliveryName>\r\n" + 
                                        "<TableDlvAddr class=\"entity\"> \r\n" + 
                                        "  <City>southbank</City>\r\n" + 
                                        "  <CountryRegionId>AUS</CountryRegionId>\r\n" + 
                                        "  <LocationName>delivery address</LocationName>\r\n" + 
                                        "  <State>VIC</State>\r\n" + 
                                        "  <Street>13075 MANCHESTER RD STE</Street> \r\n" + 
                                        "  <ZipCode>3006</ZipCode>\r\n" + 
                                        "</TableDlvAddr>\r\n" + 
                                        "<SalesLine class=\"entity\">\r\n" + 
                                        "<ItemId>CANO</ItemId>\r\n" + 
                                        "<SalesQty>20</SalesQty>\r\n" + 
                                        "<SalesPrice>82.25</SalesPrice>\r\n" + 
                                        "<SalesUnit>ltr</SalesUnit>\r\n" + 
                                        "  </SalesLine>\r\n" + 
                                        "<DocuRefHeader class=\"entity\">\r\n" + 
                                        "            <TypeId>Note</TypeId>\r\n" + 
                                        "            <Notes>Carriage Extra at Cost</Notes>\r\n" + 
                                        "            <Restriction>External</Restriction>\r\n" + 
                                        "</DocuRefHeader>\r\n" + 
                                        "</SalesTable>\r\n" + 
                                        "</SalesOrder>\r\n" + 
                                        "");
                        wr.close();
                        }
//                        output.write(text);
                    } catch ( IOException e ) {
                        e.printStackTrace();
                    } finally {
//                      if ( output != null ) {
//                        output.close();
//                      }
                    }
                    JFrame parent = new JFrame();
                            JOptionPane.showMessageDialog(parent, "XML files generated successfully"); 
                }
            
                    });
        return panel;
    }
    
    protected JComponent makeTextPanel4(String text) {
        JPanel panel = new JPanel(false);    
        JLabel Sourcepath = new JLabel(text);
        final JTextField Sourcepathtext = new JTextField(18);
        
//        panel.setBackground(Color.GREEN);
        
        Sourcepath.setText("Source path:");
        Sourcepath.setBounds(60, 80, 120, 120);
        Sourcepathtext.setBounds(10, 10, 10, 30);
        
        JLabel Destinationpath = new JLabel(text);
        final JTextField Destinationpathtext = new JTextField(18);
        Destinationpathtext.setBounds(10, 10, 10, 30);
        
        Destinationpath.setText("Destination path:");
        Destinationpath.setBounds(200, 140, 500, 20);
        
        JLabel FindInvoice = new JLabel(text);
        final JTextField FindInvoicetext = new JTextField(18);
        FindInvoicetext.setBounds(10, 10, 10, 10);
        
        FindInvoice.setText("FindInvoice:");
        FindInvoice.setBounds(200, 140, 500, 20);
        
        
        JLabel Replacefrom = new JLabel(text);
        final JTextField Replacefromtext = new JTextField(18);
        Replacefromtext.setBounds(10, 10, 10, 3);
        
        Replacefrom.setText("ReplaceFrom:");
        Replacefrom.setBounds(200, 140, 500, 20);
        
        JLabel doccount = new JLabel(text);
        final JTextField doccounttext = new JTextField(18);
        doccounttext.setBounds(10, 10, 10, 3);
        
        doccount.setText("Document Count:");
        doccount.setBounds(200, 140, 500, 20);
        
        panel.add(Sourcepath);
        panel.add(Sourcepathtext);
        panel.add(Destinationpath);
        panel.add(Destinationpathtext);
        panel.add(FindInvoice);
        panel.add(FindInvoicetext);
        panel.add(Replacefrom);
        panel.add(Replacefromtext);
        panel.add(doccount);
        panel.add(doccounttext);
        
        JButton btnCreatenp=new JButton("Create Document");
        btnCreatenp.setBounds(150,200,120, 40);
                panel.add(btnCreatenp);
                
                btnCreatenp.addActionListener(new java.awt.event.ActionListener() {
                        
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
//                FileSystem fileSys = FileSystems.getDefault();
                        
//                private static String inputFileName = "C:\\Users\\ABB2499\\Desktop\\ExpenseInvoice.docx";
//                
//                private static String outputFileName = "C:\\Users\\ABB2499\\Desktop\\ExpenseInvoice";
//                
//                private static String findString = "2342";
//                
//                private static int replaceString = 2343;
                    
                String inputFileName = Sourcepathtext.getText();
                String outputFileName = Destinationpathtext.getText();
                String findString = FindInvoicetext.getText();
                String replaceString = Replacefromtext.getText();
                String Documentcount = doccounttext.getText();
                        
                int DocCount = Integer.parseInt(Documentcount);
                        
                int replacevalue = Integer.parseInt(replaceString);
                        
                int replaceString1;
                


                System.out.println("Process Started...");
                System.out.println(outputFileName);
                
                for(int i=0;i<DocCount;i++)
                {
                if(i==0)
                {
                        replaceString1 = replacevalue;
                }
                else
                {
                        replaceString1 = replacevalue + i;
                }
                
                String        outputFileName1 = outputFileName + replaceString1 +".docx";
                
//                System.out.println(outputFileName1);
                        
                XWPFDocument doc;
                try {
                        doc = new XWPFDocument(OPCPackage.open(inputFileName));
                        for (XWPFTable tbl : doc.getTables()) {
                        for (XWPFTableRow row : tbl.getRows()) {
                         for (XWPFTableCell cell : row.getTableCells()) {
                          for (XWPFParagraph p : cell.getParagraphs()) {
//                                  List<XWPFRun> runs = p.getRuns();
                                  for(XWPFRun runs : p.getRuns()) {
//                                  if (runs != null) {
//                                          replaceIfMatches(runs);
                                          String text = runs.getText(0);
                                                      if (text !=null && text.contains(findString)) {
//                                                      System.out.println("Inside If..");
                                                      String replaceno =Integer.toString(replaceString1);
                                                      text = text.replace(findString, replaceno);
                                                      runs.setText(text, 0);
                                                                                
                                  }
//                                  }
                          }
                       }
                      }
                        }
                        }
                        doc.write(new FileOutputStream(outputFileName1));
//                        System.out.println("Process ends..");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                }
                
                JFrame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "Documents created successfully");
                
            }
            
            
//        private void replaceIfMatches(List<XWPFRun> runs) {
//                for (XWPFRun run : runs) {
//                        String text = run.getText(0);
//                        if (text !=null && text.contains(findString)) {
////                                System.out.println("Inside If..");
//                                String replaceno =Integer.toString(replaceString1);
//                                text = text.replace(findString, replaceno);
//                                run.setText(text, 0);
//                        }
//                }
//        }
            
                        
            });
        return panel;
    }


    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
       java.net.URL imgURL = JavaUtility.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
           //System.err.println("Couldn't find file: " + path);
            return null;
       }
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);


        //Create and set up the window.
        JFrame frame = new JFrame("JavaUtility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create and set up the content pane.
        JComponent newContentPane = new JavaUtility();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.getContentPane().add(new JavaUtility(),
                                 BorderLayout.CENTER);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}