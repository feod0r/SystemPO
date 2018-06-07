public class Link {

    public Double data2;
    public Link nextLink;

    //Link constructor
    public Link(Double d2) {
        data2 = d2;
    }

    //Print Link data
    public void printLink() {
        System.out.print("{" + data2 + "} ");
    }

    @Override
    public String toString() {
        return "Link{" +
                "data2=" + data2 +
                ", nextLink=" + nextLink +
                '}';
    }
}
