/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UuidNil extends org.jooq.impl.AbstractRoutine<java.util.UUID> {

	private static final long serialVersionUID = -235370965;

	/**
	 * The parameter <code>ehr.uuid_nil.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * Create a new routine call instance
	 */
	public UuidNil() {
		super("uuid_nil", com.ethercis.dao.jooq.Ehr.EHR, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
	}
}