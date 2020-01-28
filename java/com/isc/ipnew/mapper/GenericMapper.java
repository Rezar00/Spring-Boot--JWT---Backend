package com.isc.ipnew.mapper;

import java.util.List;

public interface GenericMapper<Entity, Model> {
    Entity modelToEntity(Model model);

    Model entityToModel(Entity entity);

    List<Entity> modelsToEntities(List<Model> modelList);

    List<Model> entitiesToModel(List<Entity> entityList);

}
