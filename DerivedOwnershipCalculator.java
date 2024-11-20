package com.spring.mongo;

import java.util.HashMap;
import java.util.Map;

public class DerivedOwnershipCalculator {
    public static void main(String[] args) {
        // Example: Create entities
        Entity A = new Entity("A", 1.0); // Root
        Entity B = new Entity("B", 1.0);
        Entity C = new Entity("C", 1.0);
        Entity D = new Entity("D", 1.0);

        // Define parent relationships
        B.addParent(A, 0.95); // B is owned 100% by A
        C.addParent(A, 0.95); // C is owned 100% by A
        D.addParent(B, 0.5); // D is owned 50% by B
        D.addParent(C, 0.4); // D is owned 40% by C

        // Cache to store computed derived ownerships
        Map<Entity, Double> cache = new HashMap<>();

        // Calculate and print derived ownerships
        //System.out.println("Derived Ownership of A: " + A.calculateDerivedOwnership(cache));
        //System.out.println("Derived Ownership of B: " + B.calculateDerivedOwnership(cache));
        //System.out.println("Derived Ownership of C: " + C.calculateDerivedOwnership(cache));
        System.out.println("Derived Ownership of D: " + D.calculateDerivedOwnership(cache));
    }
}
