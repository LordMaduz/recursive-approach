package com.spring.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Entity {

    private String name;
    private double ownership; // Direct ownership of this entity
    private List<Parent> parents; // List of parents and their ownership

    public Entity(String name, double ownership) {
        this.name = name;
        this.ownership = ownership;
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addParent(Entity parent, double parentOwnership) {
        this.parents.add(new Parent(parent, parentOwnership));
    }

    public double calculateDerivedOwnership(Map<Entity, Double> cache) {
        // If already calculated, return the cached result
        if (cache.containsKey(this)) {
            return cache.get(this);
        }

        // Root node case (no parents)
        if (parents.isEmpty()) {
            cache.put(this, ownership);
            return ownership;
        }

        // Calculate derived ownership
        double derivedOwnership = 0;
        for (Parent parent : parents) {
            derivedOwnership += ownership * parent.parentOwnership * parent.entity.calculateDerivedOwnership(cache);
        }

        // Cache the result for future reference
        cache.put(this, derivedOwnership);
        return derivedOwnership;
    }

    // Nested class to represent a parent and its ownership
    private static class Parent {
        Entity entity;
        double parentOwnership;

        Parent(Entity entity, double parentOwnership) {
            this.entity = entity;
            this.parentOwnership = parentOwnership;
        }
    }
}
