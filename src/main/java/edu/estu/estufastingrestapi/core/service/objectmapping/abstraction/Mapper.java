package edu.estu.estufastingrestapi.core.service.objectmapping.abstraction;

@FunctionalInterface
public interface Mapper<Source, Destination> {

    Destination map(Source source);

}
