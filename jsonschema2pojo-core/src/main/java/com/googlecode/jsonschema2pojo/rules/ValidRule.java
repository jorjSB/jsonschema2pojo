/**
 * Copyright © 2010-2013 Nokia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.jsonschema2pojo.rules;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonschema2pojo.Schema;
import com.sun.codemodel.JFieldVar;

public class ValidRule implements SchemaRule<JFieldVar, JFieldVar> {
	
	private final RuleFactory ruleFactory;
	
	public ValidRule(RuleFactory ruleFactory) {
		this.ruleFactory = ruleFactory;
	}

	@Override
	public JFieldVar apply(String nodeName, JsonNode node, JFieldVar field, Schema currentSchema) {
		
		if (ruleFactory.getGenerationConfig().isIncludeJsr303Annotations()) {
            field.annotate(Valid.class);
        }
		
        return field;
	}
	
}
