package vn.com.momo.demo.interator;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Item> menu = new ArrayList<>();

    public void add(Item item) {
        menu.add(item);
    }

    public ItemIterator<Item> itorator() {
        return new MenuIterator();
    }

    private class MenuIterator implements ItemIterator<Item> {

        private Integer currentPoint = 0;

        @Override
        public boolean hasNext() {
            return currentPoint < menu.size();
        }

        @Override
        public Item nex() {
            return menu.get(currentPoint++);
        }
    }
}
