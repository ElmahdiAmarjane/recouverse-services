-- sql code generated for creating table status
CREATE TABLE public.status (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  status VARCHAR(255) NULL,
  CONSTRAINT status_pkey PRIMARY KEY (id ASC)
)

-- based on the enum this is almost all the possible status to have
INSERT INTO public.status (id, status) VALUES
(1, 'Pré-douteux'),
(2, 'Douteux'),
(3, 'Comité des impayés'),
(4, 'Comité de déclassement agence'),
(5, 'Radié'),
(6, 'Pré-contentieux'),
(7, 'Contentieux'),
(8, 'Saisie conservation immobilière initiée'),
(9, 'Terminé');
