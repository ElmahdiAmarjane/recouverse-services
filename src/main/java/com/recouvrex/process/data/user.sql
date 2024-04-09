-- example sql creating the table
CREATE TABLE public.recouvrex_user (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  first_name VARCHAR(255) NULL,
  identification_number VARCHAR(255) NULL,
  last_name VARCHAR(255) NULL,
  user_name VARCHAR(255) NULL,
  manager_id INT8 NULL,
  profile_id INT8 NULL,
  CONSTRAINT recouvrex_user_pkey PRIMARY KEY (id ASC),
  CONSTRAINT fktdm4v3gipe15mnk2nvn0tma7j FOREIGN KEY (manager_id) REFERENCES public.recouvrex_user(id),
  CONSTRAINT fk967w86wr6x84whtlqph6c73rh FOREIGN KEY (profile_id) REFERENCES public.profile(id)
)

-- create the user 
-- the table is recouvrex_user
-- after creating a profile with id of 1 you can create this first user with the 1 for profile_id
-- and make the manager_id null
INSERT INTO recouvrex_user (first_name, identification_number, last_name, user_name, profile_id) 
VALUES ('Ayoub', 'AB1234567', 'ELOUAIZI', 'Ayoub ELOUAIZI', 1);
-- 
-- in this one we meke elmahdi as also a administrator so for the profile is 1 and
-- for the user manager_id we give the genereted id for ayoub so the ayoub is the manager
-- of elmahdi in this case
INSERT INTO recouvrex_user (first_name, identification_number, last_name, user_name, manager_id, profile_id) 
VALUES ('Elmahdi', 'ah1234567', 'ELMARJANE', 'Elmahdi elmarjane', 958664916369440769, 1);
