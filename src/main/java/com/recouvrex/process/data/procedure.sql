
CREATE TABLE public.procedure (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  procedure_label VARCHAR(255) NULL,
  CONSTRAINT procedure_pkey PRIMARY KEY (id ASC)
)


INSERT INTO public.procedure (id, procedure_label) VALUES
(1, 'Mise en demeure'),
(2, 'Saisie des fonds de commerce'),
(3, 'Saisie des biens mobiliers'),
(4, 'Saisie-arrêt bancaires'),
(5, 'Saisie conservatoire immobilière'),
(6, 'Saisie conservatoire sur les parts sociales'),
(7, 'Injonction de payer'),
(8, 'Action au fond'),
(9, 'Vente globale du fond de commerce');
