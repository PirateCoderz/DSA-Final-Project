package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomerList {
    private CustomerNode head;

    public CustomerList() {
        head = null;
    }

    public void addCustomer(Customers customer) {
        CustomerNode newNode = new CustomerNode(customer);
        if (head == null) {
            head = newNode;
        } else {
            CustomerNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public boolean deleteCustomer(String id) {
        if (head == null) {
            return false;
        }
        if (head.getCustomer().getId().equals(id)) {
            head = head.getNext();
            return true;
        }
        CustomerNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getCustomer().getId().equals(id)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean updateCustomer(String id, Customers newCustomer) {
        if (head == null) {
            return false;
        }
        if (head.getCustomer().getId().equals(id)) {
            head.setCustomer(newCustomer);
            return true;
        }
        CustomerNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getCustomer().getId().equals(id)) {
                current.getNext().setCustomer(newCustomer);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void saveCustomers(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            CustomerNode current = head;
            while (current != null) {
                oos.writeObject(current.getCustomer());
                current = current.getNext();
            }
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadCustomers(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Customers customer;
            while ((customer = (Customers) ois.readObject()) != null) {
                addCustomer(customer);
            }
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}