-- Table: public.characterclassification

-- DROP TABLE IF EXISTS public.characterclassification;

CREATE TABLE IF NOT EXISTS public.characterclassification
(
    id integer NOT NULL DEFAULT nextval('characterclassification_id_seq'::regclass),
    classification character varying(255) COLLATE pg_catalog."default",
    rare character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT characterclassification_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.characterclassification
    OWNER to nyanko;