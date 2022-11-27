package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.CollectionMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.ReversibleMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.UpdateMapper;
import org.mapstruct.MappingTarget;

import java.util.function.Supplier;

public interface MapStructMapper<Source, Destination> extends ReversibleMapper<Source, Destination>, CollectionMapper<Source, Destination>, UpdateMapper<Source, Destination> {

    @Override
    Destination mapInto(Source source, @MappingTarget Destination destination);

    default <O extends Identifiable<ID>, ID> O mapRefIgnoreNull(O old, Supplier<O> newSupp, ID id) {
        return id != null ? Identifiable.getInstance(newSupp, id) : old;
    }

}
