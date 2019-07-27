package com.dnd.graphql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dnd.beans.Spell;
import com.dnd.services.SpellService;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

@RunWith(SpringRunner.class)
@GraphQLTest
//@SpringBootTest
//@ComponentScan(basePackages = { "com.dnd.graphql"})
@ContextConfiguration(classes = {SpellDataFetchers.class, GraphQLProvider.class})
public class SpellDataFetchersTest {

//	@MockBean
//	private SpellService spellService;
//	
//    @Autowired
//    private GraphQLTestTemplate graphQLTestTemplate;
//	
//	@Test
//	public void getAllSpellsTest() throws IOException {
//        List<Spell> spells = new ArrayList<>();
//        spells.add(new Spell(1, "spell", "this is a spell"));
//        Mockito.when(spellService.getAllSpells()).thenReturn(spells);
//        
//        List<Spell> s = spellService.getAllSpells();
//        System.out.println(s.toString());
//        
//        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/allSpells.graphql");
//        assertNotNull(response);
//        System.out.println(response.getRawResponse());
//        assertTrue(response.isOk());
//        assertEquals("1", response.get("$.data.post.id"));
//	}
}
