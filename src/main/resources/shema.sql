CREATE TABLE public.product
(
    id integer NOT NULL,
    label character varying(255) NOT NULL,
    price integer NOT NULL,
    original_price integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;