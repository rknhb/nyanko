-- Table: public.characters

-- DROP TABLE IF EXISTS public.characters;

CREATE TABLE IF NOT EXISTS public.characters
(
    id bigint NOT NULL DEFAULT nextval('characters_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cost integer NOT NULL,
    rare character varying(20) COLLATE pg_catalog."default" NOT NULL,
    commentary1 text COLLATE pg_catalog."default" NOT NULL,
    commentary2 text COLLATE pg_catalog."default" NOT NULL,
    attack_frequency real NOT NULL,
    reproduction real NOT NULL,
    knockback integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT characters_pkey PRIMARY KEY (id),
    CONSTRAINT characters_name_key UNIQUE (name),
    CONSTRAINT characters_id_check CHECK (id > 0)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.characters
    OWNER to nyanko;