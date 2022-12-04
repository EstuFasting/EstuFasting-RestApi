package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.CollectionMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.ReversibleMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.UpdateMapper;
import org.mapstruct.MappingTarget;

public interface MapStructMapper<Source, Destination> extends ReversibleMapper<Source, Destination>, CollectionMapper<Source, Destination>, UpdateMapper<Source, Destination> {

    @Override
    Destination mapInto(Source source, @MappingTarget Destination destination);

}
