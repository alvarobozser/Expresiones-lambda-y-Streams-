package com.examples;

import util.Database;
import util.Videogame;

import java.util.List;

public class ParallelStreamIntro {

    public static void main(String[] args) {
        Database.videogames.parallelStream()
                .forEach(v -> System.out.println(Thread.currentThread().getName() + " - " + v));
    }
}
