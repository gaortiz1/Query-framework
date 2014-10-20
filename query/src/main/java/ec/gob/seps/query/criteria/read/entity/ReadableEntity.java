/**
 * 
 */
package ec.gob.seps.query.criteria.read.entity;

import java.util.Set;

import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeJoin;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeOperadoLogico;

/**
 * @author gortiz
 *
 */
public interface ReadableEntity {
	
	Set<AttributeOperadoLogico<?,?>> getBasicFields();
	
	Set<AttributeJoin<?>> getBeanFields();
	
}