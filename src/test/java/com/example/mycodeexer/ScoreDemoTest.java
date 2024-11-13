package com.example.mycodeexer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDemoTest {

    @Test
    void scoreLedadwadvel1() {
        ScoreDemo scoreDemo = new ScoreDemo();
        assertEquals("弱",scoreDemo.scoreLevel(52));
    }
    @Test
    void scoreLevel2() {
        ScoreDemo scoreDemo = new ScoreDemo();
        assertEquals("差",scoreDemo.scoreLevel(62));
    }
    @Test
    void scoreLevel3() {
        ScoreDemo scoreDemo = new ScoreDemo();
        assertEquals("中",scoreDemo.scoreLevel(80));
    }

//    @Test
//    void scoreLevel4() {
//        ScoreDemo scoreDemo = new ScoreDemo();
//        assertEquals("良", scoreDemo.scoreLevel(82));
//    }
    @Test
    void scoreLevel5() {
        ScoreDemo scoreDemo = new ScoreDemo();
        assertThrows(IllegalArgumentException.class,()-> scoreDemo.scoreLevel(-7));
    }
}