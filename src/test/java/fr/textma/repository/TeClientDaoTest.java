package fr.textma.repository;

import fr.textma.TextmaApp;
import fr.textma.model.TeClient;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TeClientDaoTest extends TestCase {
//    @Autowired
//    private TeClientDao dao;
//
//    @Test
//    public void testFindByLikeName() {
//        Page<TeClient> results = dao.findByLikeName("MODE", null);
//        assertNotNull(results);
//    }
}
