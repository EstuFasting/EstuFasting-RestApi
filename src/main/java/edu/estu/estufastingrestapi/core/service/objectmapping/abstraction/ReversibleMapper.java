package edu.estu.estufastingrestapi.core.service.objectmapping.abstraction;

public interface ReversibleMapper<Source, Destination> extends Mapper<Source, Destination> {

    Source mapReverse(Destination destination);

}
