package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquadTest {

    @Test
        public void newSquadShouldInstantiateCorrectly() {
            Squad newSquad = Squad.createNewSquad();
            assertTrue(true);
        }
        @Test
        public void newSquadShouldGetStringName() {
            Squad newSquad = Squad.createNewSquad();
            assertEquals("Avengers",newSquad.getName());
        }
        @Test
        public void newSquadShouldGetIntSize() {
            Squad newSquad = Squad.createNewSquad();
            assertEquals(5,newSquad.getSize());
        }
        @Test
        public void newSquadShouldGetPowerString() {
            Squad newSquad = Squad.createNewSquad();
            assertEquals("fight crime",newSquad.getMission());
        }
        @Test
        public void newSquadShouldGetInstances() {
            Squad newSquad = Squad.createNewSquad();
            Squad another = Squad.createNewSquad();
            assertTrue(Squad.getInstances().contains(newSquad));
            assertTrue(Squad.getInstances().contains(another));
        }
        @Test
        public void newSquadGetSquadHeroesArray() {
            Squad newSquad = Squad.createNewSquad();
            Heroes newHero = Heroes.createNewHero();
            Heroes newHero1 = Heroes.createNewHero1();
            newSquad.setSquadHeroes(newHero);
            assertEquals("Superman",newSquad.getSquadHeroes().get(0).getName());
        }

        @Test
        public void newSquad_allTestSquadMembers_Array() {
            Heroes newHero = Heroes.createNewHero();
            Squad newSquad = Squad.createNewSquad();
            newSquad.clearAllSquadHeroes();
            newSquad.getSquadHeroes().add(newHero);
            newSquad.getSquadHeroes().add(newHero);
            assertEquals("Superman",newSquad.getSquadHeroes().get(0).getName());
        }
        @Test
        public void addMember_addsMemberToSquad_Hero(){
            Heroes newHero = Heroes.createNewHero();
            Squad testSquad = Squad.createNewSquad();
            Squad newSquad = Squad.findById(1);
            newSquad.clearAllSquadHeroes();
            newSquad.getSquadHeroes().add(newHero);
            newSquad.getSquadHeroes().add(newHero);
            assertEquals(2,newSquad.getSquadHeroes().size());
        }

        @Test
        public void setNewMember_hero(){
            Heroes.clearAllHeroes();
            Heroes newHero = Heroes.createNewHero();
            Squad testSquad = Squad.createNewSquad();
            testSquad.setSquadHeroes(newHero);

            assertEquals(1,testSquad.getSquadHeroes().get(0).getId());
        }


    }