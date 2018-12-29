package com.shellucas.RESTLibrary.dbaccess;

import java.util.List;

/**
 * The interface provides a generic set of rules for any access point to a database.
 *
 * @author shelby
 * @param <T>
 */
public interface DBAccess<T> {

    /**
     * Gets all entities from the database.
     * @return Returns List of entities
     */
    List<T> get();

    /**
     * Gets a single entity from the database specified by the id.
     * @param id The ID of the entity.
     * @return the entity object.
     */
    T getById(int id);

    /**
     * Posts a new entity to the database.
     * @param e Entity to be posted
     */
    void post(T e);

    /**
     * Updates(Puts) an entity from the database.
     * @param e The entity to be updated.
     * @return True if successfully updated.
     */
    boolean put(T e);

    /**
     * Delete an entity from the database.
     * @param id The ID of the entity.
     * @return True if successfully deleted.
     */
    boolean delete(int id);

    /**
     * Print the entities in the database.
     */
    void print();
}
