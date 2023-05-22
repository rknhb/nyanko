-- Table: public.rarity

-- DROP TABLE IF EXISTS public.rarity;

CREATE TABLE IF NOT EXISTS public.rarity
(
    id integer NOT NULL DEFAULT nextval('rarity_id_seq'::regclass),
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT rarity_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rarity
    OWNER to nyanko;