package vn.com.momo.demo.interator;

public class TestMain {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add(new Item("A","name A"));
        menu.add(new Item("B","name B"));
        menu.add(new Item("C","name C"));
        menu.add(new Item("D","name D"));
        menu.add(new Item("E","name E"));

        ItemIterator<Item> itorator = menu.itorator();
        while (itorator.hasNext()){
            System.out.println(itorator.nex().getTitle());
        }
    }
}
