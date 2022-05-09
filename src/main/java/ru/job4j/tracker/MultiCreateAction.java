package ru.job4j.tracker;

public class MultiCreateAction implements UserAction {

    private final Output out;

    public MultiCreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create many new Item ===");
        String name = input.askStr("Enter name: ");
        int count = input.askInt("How much Items create: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item(name);
            store.add(item);
        }
        out.println("Добавленная заявка: " + count);
        return true;
    }
}
