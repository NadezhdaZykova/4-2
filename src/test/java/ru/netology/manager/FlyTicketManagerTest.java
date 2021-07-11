package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlyTicket;
import ru.netology.repository.FlyTicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlyTicketManagerTest {

    FlyTicketRepository flyTicketRepository = new FlyTicketRepository();
    FlyTicketManager flyTicketManager = new FlyTicketManager(flyTicketRepository);

    FlyTicket likeTicket1 = new FlyTicket(0, 1000, "KUF", "LED", 60);
    FlyTicket likeTicket2 = new FlyTicket(1, 1500, "LED", "KUF", 112);
    FlyTicket likeTicket3 = new FlyTicket(2, 780, "GOJ", "FRD", 78);
    FlyTicket likeTicket4 = new FlyTicket(3, 900, "SVN", "BGN", 90);
    FlyTicket likeTicket5 = new FlyTicket(4, 1200, "KUF", "LED", 100);
    FlyTicket likeTicket6 = new FlyTicket(5, 2000, "SVN", "LED", 120);

    @Test
    void findAllMany() {
        flyTicketManager.add(likeTicket1);
        flyTicketManager.add(likeTicket2);
        flyTicketManager.add(likeTicket3);
        flyTicketManager.add(likeTicket4);
        flyTicketManager.add(likeTicket5);
        flyTicketManager.add(likeTicket6);

        assertArrayEquals(new FlyTicket[]{likeTicket1, likeTicket5}, flyTicketManager.findAll("kuf", "led"));
    }

    @Test
    void findAllOne() {
        flyTicketManager.add(likeTicket1);
        flyTicketManager.add(likeTicket2);
        flyTicketManager.add(likeTicket3);
        flyTicketManager.add(likeTicket4);
        flyTicketManager.add(likeTicket5);
        flyTicketManager.add(likeTicket6);

        assertArrayEquals(new FlyTicket[]{likeTicket3}, flyTicketManager.findAll("goj", "Frd"));
    }

    @Test
    void findAllNothing() {
        flyTicketManager.add(likeTicket1);
        flyTicketManager.add(likeTicket2);
        flyTicketManager.add(likeTicket3);
        flyTicketManager.add(likeTicket4);
        flyTicketManager.add(likeTicket5);
        flyTicketManager.add(likeTicket6);

        assertArrayEquals(new FlyTicket[]{}, flyTicketManager.findAll("kgf", "ufc"));
    }
}