/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetTypeRepository;

/**
 * @author akanchev
 */
public class JdbcPetTypeRepositoryImpl implements PetTypeRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcPetTypeRepositoryImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<PetType> findPetTypes() throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        return this.namedParameterJdbcTemplate.query("SELECT id, name FROM types ORDER BY name", params,
                ParameterizedBeanPropertyRowMapper.newInstance(PetType.class));
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.samples.petclinic.repository.PetTypeRepository#save(org.springframework.samples.petclinic
     * .model.PetType)
     */
    @Override
    public PetType save(PetType petType) throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }

}
