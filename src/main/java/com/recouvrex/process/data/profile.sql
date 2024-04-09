-- the table is profile
-- the sql code for ceation
CREATE TABLE public.profile (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  profile VARCHAR(255) NULL,
  CONSTRAINT profile_pkey PRIMARY KEY (id ASC)
)

-- create example fo profile row/profile 
INSERT INTO public.profile (profile) VALUES ('Developer');
-- also
INSERT INTO public.profile (id, profile) VALUES (1, 'Administrator');
-- also
INSERT INTO public.profile (profile) 
VALUES 
    ('Project Manager'),
    ('Data Analyst'),
    ('UX Designer'),
    ('Quality Assurance');
