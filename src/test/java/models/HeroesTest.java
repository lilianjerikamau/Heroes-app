package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroesTest {

    @Test
    public void newHero_instantiatesCorrectly_true() {
        Heroes newHero = Heroes.createNewHero();
        assertTrue(newHero instanceof Heroes);
    }
    @Test
    public void newHero_getName_String() {
        Heroes newHero = Heroes.createNewHero();
        assertEquals("Superman",newHero.getName());
    }
    @Test
    public void newHero_getAge_Int() {
        Heroes newHero = Heroes.createNewHero();
        assertEquals(23,newHero.getAge());
    }
    @Test
    public void newHero_getPower_String() {
        Heroes newHero = Heroes.createNewHero();
        assertEquals("Flying",newHero.getPower());
    }
    @Test
    public void newHero_getWeakness_String() {
        Heroes newHero = Heroes.createNewHero();
        assertEquals("Fire",newHero.getWeakness());
    }
    @Test
    public void newHero_getAllInstances_true() {
        Heroes newHero = Heroes.createNewHero();
        Heroes another = Heroes.createNewHero();
        assertTrue(Heroes.getInstances().contains(newHero));
        assertTrue(Heroes.getInstances().contains(another));
    }
    @Test
    public void newHero_getId_Int() {
        Heroes.clearAllHeroes();
        Heroes newHero = Heroes.createNewHero();
        Heroes another = Heroes.createNewHero();
        Heroes another1 = Heroes.createNewHero();
        assertEquals(3,another1.getId());
    }
    @Test
    public void newHero_findById_id() {
        Heroes.clearAllHeroes();
        Heroes newHero = Heroes.createNewHero();
        Heroes another = Heroes.createNewHero();
        assertEquals(2,Heroes.findById(another.getId()).getId());
    }
}
