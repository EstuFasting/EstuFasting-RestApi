package edu.estu.estufastingrestapi.core.service.objectmapping.abstracts;

import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.CollectionMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.ReversibleMapper;

public interface MapStructMapper<Source, Destination> extends ReversibleMapper<Source, Destination>, CollectionMapper<Source, Destination> {
}
