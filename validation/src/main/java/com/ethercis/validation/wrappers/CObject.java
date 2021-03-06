/*
 * Copyright (c) 2015 Christian Chevalley
 * This file is part of Project Ethercis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ethercis.validation.wrappers;

import org.apache.xmlbeans.SchemaType;
import org.openehr.schemas.v1.ARCHETYPECONSTRAINT;
import org.openehr.schemas.v1.CCOMPLEXOBJECT;
import org.openehr.schemas.v1.CDOMAINTYPE;
import org.openehr.schemas.v1.CPRIMITIVEOBJECT;

import java.util.Map;

/**
 * Created by christian on 7/23/2016.
 */
public class CObject extends CConstraint implements I_CArchetypeConstraintValidate {

    protected CObject(Map<String, Map<String, String>> localTerminologyLookup) {
        super(localTerminologyLookup);
    }

    @Override
    public void validate(String path, Object aValue, ARCHETYPECONSTRAINT archetypeconstraint) throws Exception {

        SchemaType type = I_CArchetypeConstraintValidate.findSchemaType(I_CArchetypeConstraintValidate.getXmlType(archetypeconstraint));
        Object constraint = archetypeconstraint.changeType(type);

        if (constraint instanceof CCOMPLEXOBJECT)
            new CComplexObject(localTerminologyLookup).validate(path, aValue, (CCOMPLEXOBJECT)constraint);
        else if (constraint instanceof CPRIMITIVEOBJECT)
            new CPrimitive(localTerminologyLookup).validate(path, aValue, (CPRIMITIVEOBJECT)constraint);
        else if (constraint instanceof CDOMAINTYPE)
            new CDomainType(localTerminologyLookup).validate(path, aValue, (CDOMAINTYPE)constraint);
        else
            throw new IllegalArgumentException("INTERNAL: unsupported COBJECT:" + archetypeconstraint);

    }
}
