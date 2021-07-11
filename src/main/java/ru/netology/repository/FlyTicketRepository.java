package ru.netology.repository;

import ru.netology.domain.FlyTicket;
import ru.netology.exception.NotFoundException;

public class FlyTicketRepository {
    private FlyTicket[] items = new FlyTicket[0];

    public void save(FlyTicket item) {
        int length = items.length + 1;
        FlyTicket[] tmp = new FlyTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FlyTicket[] findAll() {
        return items;
    }

    public FlyTicket findById(int id) {
        for (FlyTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id = " + id + " не найден!");
        }
        int length = items.length - 1;
        FlyTicket[] tmp = new FlyTicket[length];
        int index = 0;
        for (FlyTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}