/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq;

/**
 * Convenience access to all tables in ehr
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * defines the modality for accessing an com.ethercis.ehr (security strategy implementation)
	 */
	public static final com.ethercis.dao.jooq.tables.Access ACCESS = com.ethercis.dao.jooq.tables.Access.ACCESS;

	/**
	 * The table ehr.attestation
	 */
	public static final com.ethercis.dao.jooq.tables.Attestation ATTESTATION = com.ethercis.dao.jooq.tables.Attestation.ATTESTATION;

	/**
	 * The table ehr.attested_view
	 */
	public static final com.ethercis.dao.jooq.tables.AttestedView ATTESTED_VIEW = com.ethercis.dao.jooq.tables.AttestedView.ATTESTED_VIEW;

	/**
	 * Composition table
	 */
	public static final com.ethercis.dao.jooq.tables.Composition COMPOSITION = com.ethercis.dao.jooq.tables.Composition.COMPOSITION;

	/**
	 * The table ehr.composition_history
	 */
	public static final com.ethercis.dao.jooq.tables.CompositionHistory COMPOSITION_HISTORY = com.ethercis.dao.jooq.tables.CompositionHistory.COMPOSITION_HISTORY;

	/**
	 * openEHR common concepts (e.g. terminology) used in the system
	 */
	public static final com.ethercis.dao.jooq.tables.Concept CONCEPT = com.ethercis.dao.jooq.tables.Concept.CONCEPT;

	/**
	 * Contribution table, compositions reference this table
	 */
	public static final com.ethercis.dao.jooq.tables.Contribution CONTRIBUTION = com.ethercis.dao.jooq.tables.Contribution.CONTRIBUTION;

	/**
	 * The table ehr.contribution_history
	 */
	public static final com.ethercis.dao.jooq.tables.ContributionHistory CONTRIBUTION_HISTORY = com.ethercis.dao.jooq.tables.ContributionHistory.CONTRIBUTION_HISTORY;

	/**
	 * EHR itself
	 */
	public static final com.ethercis.dao.jooq.tables.Ehr EHR = com.ethercis.dao.jooq.tables.Ehr.EHR;

	/**
	 * this table hold the actual archetyped data values (from a template)
	 */
	public static final com.ethercis.dao.jooq.tables.Entry ENTRY = com.ethercis.dao.jooq.tables.Entry.ENTRY;

	/**
	 * The table ehr.entry_history
	 */
	public static final com.ethercis.dao.jooq.tables.EntryHistory ENTRY_HISTORY = com.ethercis.dao.jooq.tables.EntryHistory.ENTRY_HISTORY;

	/**
	 * defines the context of an event (time, who, where... see openEHR IM 5.2
	 */
	public static final com.ethercis.dao.jooq.tables.EventContext EVENT_CONTEXT = com.ethercis.dao.jooq.tables.EventContext.EVENT_CONTEXT;

	/**
	 * The table ehr.event_context_history
	 */
	public static final com.ethercis.dao.jooq.tables.EventContextHistory EVENT_CONTEXT_HISTORY = com.ethercis.dao.jooq.tables.EventContextHistory.EVENT_CONTEXT_HISTORY;

	/**
	 * specifies an identifier for a party identified, more than one identifier is possible
	 */
	public static final com.ethercis.dao.jooq.tables.Identifier IDENTIFIER = com.ethercis.dao.jooq.tables.Identifier.IDENTIFIER;

	/**
	 * ISO 639-1 language codeset
	 */
	public static final com.ethercis.dao.jooq.tables.Language LANGUAGE = com.ethercis.dao.jooq.tables.Language.LANGUAGE;

	/**
	 * define a participating party for an event f.ex.
	 */
	public static final com.ethercis.dao.jooq.tables.Participation PARTICIPATION = com.ethercis.dao.jooq.tables.Participation.PARTICIPATION;

	/**
	 * The table ehr.participation_history
	 */
	public static final com.ethercis.dao.jooq.tables.ParticipationHistory PARTICIPATION_HISTORY = com.ethercis.dao.jooq.tables.ParticipationHistory.PARTICIPATION_HISTORY;

	/**
	 * The table ehr.party_identified
	 */
	public static final com.ethercis.dao.jooq.tables.PartyIdentified PARTY_IDENTIFIED = com.ethercis.dao.jooq.tables.PartyIdentified.PARTY_IDENTIFIED;

	/**
	 * specifies an ehr modality and ownership (patient)
	 */
	public static final com.ethercis.dao.jooq.tables.Status STATUS = com.ethercis.dao.jooq.tables.Status.STATUS;

	/**
	 * The table ehr.status_history
	 */
	public static final com.ethercis.dao.jooq.tables.StatusHistory STATUS_HISTORY = com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY;

	/**
	 * system table for reference
	 */
	public static final com.ethercis.dao.jooq.tables.System SYSTEM = com.ethercis.dao.jooq.tables.System.SYSTEM;

	/**
	 * openEHR identified terminology provider
	 */
	public static final com.ethercis.dao.jooq.tables.TerminologyProvider TERMINOLOGY_PROVIDER = com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER;

	/**
	 * ISO 3166-1 countries codeset
	 */
	public static final com.ethercis.dao.jooq.tables.Territory TERRITORY = com.ethercis.dao.jooq.tables.Territory.TERRITORY;
}