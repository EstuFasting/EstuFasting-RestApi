package edu.estu.estufastingrestapi.core.service.objectmapping.abstraction;

public interface Mapper<Source, Destination> {

    Destination map(Source source);

}
