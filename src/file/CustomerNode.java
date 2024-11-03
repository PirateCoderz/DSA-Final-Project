package file;
public class CustomerNode {
    private Customers customer;
    private CustomerNode next;

    public CustomerNode(Customers customer) {
        this.customer = customer;
        this.next = null;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public CustomerNode getNext() {
        return next;
    }

    public void setNext(CustomerNode next) {
        this.next = next;
    }
}