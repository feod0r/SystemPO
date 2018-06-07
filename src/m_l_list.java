public class m_l_list {

    private Link first;

    public m_l_list() {
        first = null;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public void add(Double d2) {
        Link link = new Link(d2);
        link.nextLink = first;
        first = link;
    }


    public Double find(Double value) {

        while (first != null){
            if (first.data2 == value)
                return first.data2;
            first = first.nextLink;
        }

        return -1.0;
    }

    @Override
    public String toString() {
        return "m_l_list{" +
                "first=" + first +
                '}';
    }

    public void printList() {
        Link currentLink = first;
        System.out.print("List: ");
        while(currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.nextLink;
        }
        System.out.println("");

    }



}
