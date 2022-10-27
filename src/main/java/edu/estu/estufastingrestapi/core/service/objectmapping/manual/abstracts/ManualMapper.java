package edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts;

import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.CollectionMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.Mapper;

public interface ManualMapper<Source, Destination> extends Mapper<Source, Destination>, CollectionMapper<Source, Destination> {
}
