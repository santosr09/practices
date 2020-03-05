package com.ns.dev.test;

import com.ns.dev.Player;
import com.ns.dev.PlayerRepository;
import com.ns.dev.Team;
import com.ns.dev.utils.DBConnection;
import org.junit.Before;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerRepositoryTest {

    private Connection _connection;

    @Before
    public void setUp() throws Exception {
        _connection = DBConnection.getConnection();
    }
 
    
    public void testGetPlayers() throws Exception {
        PlayerRepository PlayerRepository = new PlayerRepository(_connection);
        List<Player> Players = PlayerRepository.getPlayers();
        assertEquals(3, Players.size());

        Player john = Players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeamId());

        Player jane = Players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeamId());

        Player bob = Players.get(2);
        assertEquals("bob@nearsoft.com", bob.getUserName());
        assertEquals("Bob", bob.getFirstName());
        assertEquals("Ross", bob.getLastName());
    }

    public void testGetPlayersByTeamId() throws Exception {
        PlayerRepository PlayerRepository = new PlayerRepository(_connection);
        List<Player> Players = PlayerRepository.getPlayersByTeamId(100);
        assertEquals(2, Players.size());

        Player john = Players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeamId());

        Team softball = john.getTeam();
        assertEquals(100, softball.getId());
        assertEquals("Softball", softball.getName());

        Player jane = Players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeamId());

        assertEquals(softball, jane.getTeam());
    }

}
