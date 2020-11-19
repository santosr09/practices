package com.ns.dev.test;

import com.ns.dev.Player;
import com.ns.dev.PlayerRepository;
import com.ns.dev.Team;
import com.ns.dev.utils.DBConnection;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerRepositoryTest {

    /*private Connection _connection;
    
    List<Player> playersList;

    @BeforeAll
    public void setUp() throws Exception {
        _connection = DBConnection.getConnection();
        playersList = new ArrayList<Player>();
        Player p1 = new Player();
        p1.setFirstName("John");
        p1.setLastName("Doe");
        p1.setUserName("john@nearsoft.com");
        
        Player p2 = new Player();
        playersList.add(p1);
    }
 
    
    public void testGetPlayers() throws Exception {
        PlayerRepository PlayerRepository = new PlayerRepository(_connection);
        assertEquals(1, playersList.size());

        Player john = playersList.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        //assertEquals(100, john.getTeamId());
        
    }*/

   

}
