
package repository;

/*
repository.IRepository
Generic Repository Interface
Author: Avela Bonakali
Date: 20/03/2025
 */

import java.util.Set;

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    Set<T> getAll();
}