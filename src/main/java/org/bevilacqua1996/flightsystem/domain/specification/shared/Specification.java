package org.bevilacqua1996.flightsystem.domain.specification.shared;

public interface Specification<T> {

    boolean isSatisfiedBy(T t);

}
