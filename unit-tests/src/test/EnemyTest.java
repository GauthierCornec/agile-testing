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

public class EnemyTest {

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
		enemy = new Enemy("Hello", 1);
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

    @Test 
    public void testEnemyProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("name", is("Hello")));
    }

    @Test  
    public void testEnemyAttack() throws Exception {
        enemy.attack(hero);
        assertThat(hero.getHp(), allOf(greaterThan(15), lessThan(20)));
    }

    @Test 
    public void testEnemyTakeDamage() throws Exception {
        enemy.takeDamage(3);
        assertThat(hero.getHp(),allOf(greaterThan(17), lessThan(21)));
    }
}