/*
 * Copyright 2002-2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.PetTypeRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @author Thomas Risberg
 * @author Mark Fisher
 */
@Repository
public class JdbcPetRepositoryImpl implements PetRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertPet;

    private final OwnerRepository ownerRepository;

    private final VisitRepository visitRepository;

    private final PetTypeRepository petTypeRepository;


    @Autowired
    public JdbcPetRepositoryImpl(DataSource dataSource, OwnerRepository ownerRepository,
            VisitRepository visitRepository, PetTypeRepository petTypeRepository) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        this.insertPet = new SimpleJdbcInsert(dataSource).withTableName("pets").usingGeneratedKeyColumns("id");

        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Pet findOne(Integer id) throws DataAccessException {
        JdbcPet pet;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
            pet =
                    this.namedParameterJdbcTemplate.queryForObject(
                            "SELECT id, name, birth_date, type_id, owner_id FROM pets WHERE id=:id", params,
                            new JdbcPetRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(Pet.class, new Integer(id));
        }
        Owner owner = this.ownerRepository.findOne(pet.getOwnerId());
        pet.setOwner(owner);
        // pet.setType(EntityUtils.getById(petTypeRepository.findPetTypes(), PetType.class, pet.getTypeId()));

        List<Visit> visits = this.visitRepository.findByPetId(pet.getId());
        for (Visit visit : visits) {
            // visit.setPet(pet);
        }
        return pet;
    }

    @Override
    public Pet save(Pet pet) throws DataAccessException {
        if (pet.isNew()) {
            Number newKey = this.insertPet.executeAndReturnKey(createPetParameterSource(pet));
            pet.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE pets SET name=:name, birth_date=:birth_date, type_id=:type_id, "
                            + "owner_id=:owner_id WHERE id=:id", createPetParameterSource(pet));
        }
        return pet;
    }

    /**
     * Creates a {@link MapSqlParameterSource} based on data values from the supplied {@link Pet} instance.
     */
    private MapSqlParameterSource createPetParameterSource(Pet pet) {
        return new MapSqlParameterSource().addValue("id", pet.getId()).addValue("name", pet.getName())
                .addValue("birth_date", pet.getBirthDate().toDate()).addValue("type_id", pet.getType().getId())
                .addValue("owner_id", pet.getOwner().getId());
    }
}
