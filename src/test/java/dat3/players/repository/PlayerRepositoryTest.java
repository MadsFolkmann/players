package dat3.players.repository;

import dat3.players.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
    playerRepository.save(new Player("Giroud", "France", "Forward"));
    playerRepository.save(new Player("Dijk", "Holland", "Defender"));
    }

    @Test
    public void testAllPlayers() {
        assertEquals(2, playerRepository.count());
    }
    @Test
    public void testAddPlayer() {
        Player pNew = new Player("Messi", "Argentina", "Forward");
        System.out.println(pNew);
        playerRepository.save(pNew);
        assertTrue(pNew.getId() > 0);
        assertEquals(3, playerRepository.count());
    }


    public void alwaysFail() {
        assertTrue(false);
    }
}