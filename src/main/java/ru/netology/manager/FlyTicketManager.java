package ru.netology.manager;


import ru.netology.domain.FlyTicket;
import ru.netology.repository.FlyTicketRepository;

import java.util.Arrays;
import java.util.Locale;

public class FlyTicketManager {
    private FlyTicketRepository flyTicketRepository;

    FlyTicketManager(FlyTicketRepository flyTicketRepository) {
        this.flyTicketRepository = flyTicketRepository;
    }

    public void add(FlyTicket flyTicket) {
        flyTicketRepository.save(flyTicket);
    }

    public FlyTicket[] findAll(String from, String to) {
        FlyTicket[] result = new FlyTicket[0];
        for (FlyTicket flyTicket : flyTicketRepository.findAll()) {
            if (flyTicket.getAirportFrom().equalsIgnoreCase(from) & flyTicket.getAirportTo().equalsIgnoreCase(to)) {
                FlyTicket[] tmp = new FlyTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flyTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
