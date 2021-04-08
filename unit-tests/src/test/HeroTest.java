package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class HeroTest {

	Enemy enemy;
	Hero hero;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		enemy = new Enemy("hello", 1);
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}


	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
        assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
	}

	@Test
	public void testHeroGetHp() throws Exception {
		assertThat(hero.getHp(), is (20));
	}

	@Test 
	public void testHeroGetLevel() throws Exception {
		assertThat(hero.getLevel(), is (1));
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		hero.levelUp();
		assertThat(hero.getLevel(), is (2));
	}

	@Test
	public void testHeroAtk() throws Exception{
		hero.attack(enemy);
		assertThat(enemy.getHp(), allOf(greaterThan(10), lessThan(14)));
	}

	@Test
	public void testHeroTakeDamage() throws Exception {
		hero.takeDamage(8);
		assertThat(hero.getHp(), is (12));
	}
}
