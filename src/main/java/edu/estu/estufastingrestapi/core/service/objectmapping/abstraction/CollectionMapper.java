package edu.estu.estufastingrestapi.core.service.objectmapping.abstraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CollectionMapper<Source, Destination> extends Mapper<Source, Destination> {

    default List<Destination> mapCollection(Collection<Source> sources) {
        if (sources == null) return new ArrayList<>();
        List<Destination> destinations = new ArrayList<>(sources.size());
        for (Source source : sources)
            destinations.add(map(source));
        return destinations;
    }

    default List<Destination> mapCollection(Source[] sources) {
        if (sources == null) return new ArrayList<>();
        List<Destination> destinations = new ArrayList<>(sources.length);
        for (Source source : sources)
            destinations.add(map(source));
        return destinations;
    }

}
