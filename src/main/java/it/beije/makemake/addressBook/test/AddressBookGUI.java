package it.beije.makemake.addressBook.test;


import it.beije.makemake.addressBook.AddressBook;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

class AddressBookGUI extends Frame implements WindowListener, ActionListener {

    Panel mainPanel = new Panel(new GridBagLayout());
    AddressBook addressBook = new AddressBook();

    public AddressBookGUI() {
        addWindowListener(this);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu importSubMenu = new Menu("Import from");
        MenuItem csvMenuItem = new MenuItem("CSV");
        csvMenuItem.setActionCommand("import_csv");
        csvMenuItem.addActionListener(this);
        MenuItem xmlMenuItem = new MenuItem("XML");
        xmlMenuItem.setActionCommand("import_xml");
        xmlMenuItem.addActionListener(this);
        MenuItem dbMenuItem = new MenuItem("Database");
        dbMenuItem.setActionCommand("import_db");
        dbMenuItem.addActionListener(this);
        importSubMenu.add(csvMenuItem);
        importSubMenu.add(xmlMenuItem);
        importSubMenu.add(dbMenuItem);
        fileMenu.add(importSubMenu);
        menuBar.add(fileMenu);
        this.setMenuBar(menuBar);
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "import_csv":
                break;
            case "import_xml":
                try {
                    addressBook = AddressBook.createFromXML(fileInputDialog());
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "import_db":
                break;
        }
    }

    public String fileInputDialog() {
        String s = JOptionPane.showInputDialog("Inserisci percorso del file");
        return s;
    }
}







